package com.example.cinemabooking.services;

import com.example.cinemabooking.request.TicketRequest;
import com.example.cinemabooking.response.TicketResponse;

public interface TicketService {

    TicketResponse ticketBooking(TicketRequest ticketRequest);

}
