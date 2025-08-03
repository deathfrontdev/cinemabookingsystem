package com.example.cinemabooking.controllers;

import com.example.cinemabooking.request.ShowRequest;
import com.example.cinemabooking.services.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Show Controller", description = "Операции для управления киносеансами")
@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @Operation(summary = "Добавить новый киносеанс", description = "Создаёт новый киносеанс с местами на основе TheaterSeat")
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addNew")
    public ResponseEntity<String> addShow(@Valid @RequestBody ShowRequest showRequest) {
        try {
            String result = showService.addShow(showRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
