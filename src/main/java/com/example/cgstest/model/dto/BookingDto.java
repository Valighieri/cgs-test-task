package com.example.cgstest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class BookingDto {
    private Long   routeId;
    private Integer seatNumber;
    private String passengerFirstName;
    private String passengerLastName;
    private Instant bookedAt;
}
