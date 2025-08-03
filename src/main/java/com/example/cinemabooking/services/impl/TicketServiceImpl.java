package com.example.cinemabooking.services.impl;

import com.example.cinemabooking.converter.TicketConvertor;
import com.example.cinemabooking.entities.Show;
import com.example.cinemabooking.entities.ShowSeat;
import com.example.cinemabooking.entities.Ticket;
import com.example.cinemabooking.entities.User;
import com.example.cinemabooking.exceptions.SeatsNotAvailable;
import com.example.cinemabooking.exceptions.ShowDoesNotExists;
import com.example.cinemabooking.exceptions.UserDoesNotExists;
import com.example.cinemabooking.repositories.ShowRepository;
import com.example.cinemabooking.repositories.TicketRepository;
import com.example.cinemabooking.repositories.UserRepository;
import com.example.cinemabooking.request.TicketRequest;
import com.example.cinemabooking.response.TicketResponse;
import com.example.cinemabooking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public TicketResponse ticketBooking(TicketRequest ticketRequest) {
        Optional<Show> showOpt = showRepository.findById(ticketRequest.getShowId());
        if (showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }

        Optional<User> userOpt = userRepository.findById(ticketRequest.getUserId());
        if (userOpt.isEmpty()) {
            throw new UserDoesNotExists();
        }

        User user = userOpt.get();
        Show show = showOpt.get();
        List<String> requestSeats = ticketRequest.getRequestSeats();

        if (!isSeatAvailable(show.getShowSeatList(), requestSeats)) {
            throw new SeatsNotAvailable();
        }

        int totalPrice = assignSeatsAndCalculatePrice(show.getShowSeatList(), requestSeats);
        String bookedSeatsString = String.join(",", requestSeats);

        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(totalPrice);
        ticket.setBookedSeats(bookedSeatsString);
        ticket.setUser(user);
        ticket.setShow(show);

        ticket = ticketRepository.save(ticket);
        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);

        // WebSocket оповещение об обновлении мест
        Map<String, Object> seatUpdatePayload = new HashMap<>();
        seatUpdatePayload.put("showId", show.getShowId());
        seatUpdatePayload.put("bookedSeats", requestSeats);
        messagingTemplate.convertAndSend("/topic/seats/" + show.getShowId(), seatUpdatePayload);

        return TicketConvertor.returnTicket(show, ticket);
    }

    private boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats) {
        for (ShowSeat showSeat : showSeatList) {
            if (requestSeats.contains(showSeat.getSeatNo()) && !showSeat.getIsAvailable()) {
                return false;
            }
        }
        return true;
    }

    private int assignSeatsAndCalculatePrice(List<ShowSeat> showSeatList, List<String> requestSeats) {
        int totalPrice = 0;
        for (ShowSeat showSeat : showSeatList) {
            if (requestSeats.contains(showSeat.getSeatNo())) {
                showSeat.setIsAvailable(false);
                totalPrice += showSeat.getPrice();
            }
        }
        return totalPrice;
    }
}
