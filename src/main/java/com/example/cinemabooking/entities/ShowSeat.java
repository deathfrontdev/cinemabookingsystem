package com.example.cinemabooking.entities;

import com.example.cinemabooking.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "SHOW_SEATS")
@Data
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    private Boolean isAvailable;

    private Boolean isFoodContains;

    @ManyToOne
    @JoinColumn(name = "show_id") // имя колонки в БД
    private Show show;
}
