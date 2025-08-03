package com.example.cinemabooking.repositories;

import com.example.cinemabooking.entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {

    // Получить все доступные места по showId
    List<ShowSeat> findByShow_ShowIdAndIsAvailableTrue(Integer showId);
}
