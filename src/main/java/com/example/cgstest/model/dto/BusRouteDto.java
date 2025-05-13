package com.example.cgstest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusRouteDto {
    private Long id;
    private String routeName;
    private Integer seatCount;
}