package com.example.cinemabooking.repositories;

import com.example.cinemabooking.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
