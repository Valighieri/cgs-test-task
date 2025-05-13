package com.example.cgstest.model.dto;


import com.example.cgstest.model.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SeatStatusDto {
    private Integer seatNumber;
    private SeatStatus status;
}
