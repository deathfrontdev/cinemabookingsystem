package com.example.cinemabooking.controllers;

import com.example.cinemabooking.dto.SeatUpdateMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WebSocketSeatController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/seat/update") // "/app/seat/update"
    public void updateSeat(SeatUpdateMessage message) {
        messagingTemplate.convertAndSend("/topic/seats/" + message.getShowId(), message);
    }
}
