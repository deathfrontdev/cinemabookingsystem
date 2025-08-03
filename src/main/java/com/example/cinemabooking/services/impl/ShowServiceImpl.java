package com.example.cinemabooking.services.impl;

import com.example.cinemabooking.converter.ShowConvertor;
import com.example.cinemabooking.entities.*;
import com.example.cinemabooking.enums.SeatType;
import com.example.cinemabooking.exceptions.MovieDoesNotExists;
import com.example.cinemabooking.exceptions.ShowDoesNotExists;
import com.example.cinemabooking.exceptions.TheaterDoesNotExists;
import com.example.cinemabooking.repositories.MovieRepository;
import com.example.cinemabooking.repositories.ShowRepository;
import com.example.cinemabooking.repositories.TheaterRepository;
import com.example.cinemabooking.request.ShowRequest;
import com.example.cinemabooking.request.ShowSeatRequest;
import com.example.cinemabooking.response.ShowResponse;
import com.example.cinemabooking.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Override
    public String addShow(ShowRequest showRequest) {
        Show show = ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());
        if (movieOpt.isEmpty()) throw new MovieDoesNotExists();

        Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());
        if (theaterOpt.isEmpty()) throw new TheaterDoesNotExists();

        Movie movie = movieOpt.get();
        Theater theater = theaterOpt.get();

        show.setMovie(movie);
        show.setTheater(theater);

        // Сохраняем show
        show = showRepository.save(show);

        // Привязываем show к movie и theater
        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        // 💡 Создаём ShowSeat для каждого TheaterSeat
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();
        for (TheaterSeat theaterSeat : theaterSeatList) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());
            showSeat.setShow(show);
            showSeat.setIsAvailable(true);
            showSeat.setIsFoodContains(false);

            // Установка цены в зависимости от типа
            if (theaterSeat.getSeatType() == SeatType.STANDARD) {
                showSeat.setPrice(2000); // можно вынести в переменные
            } else {
                showSeat.setPrice(4000);
            }

            show.getShowSeatList().add(showSeat);
        }

        showRepository.save(show); // Сохраняем всё вместе

        return "Show and its seats have been added successfully";
    }
    @Override
    public List<ShowResponse> getShowsByMovieId(Integer movieId) {
        Optional<Movie> movieOpt = movieRepository.findById(movieId);
        if (movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }

        Movie movie = movieOpt.get();
        List<Show> showList = movie.getShows();

        return showList.stream().map(show -> ShowResponse.builder()
                .showId(show.getShowId())
                .date(show.getDate())
                .time(show.getTime())
                .theaterName(show.getTheater().getName())
                .movieTitle(movie.getMovieName())
                .build()
        ).toList();
    }
}