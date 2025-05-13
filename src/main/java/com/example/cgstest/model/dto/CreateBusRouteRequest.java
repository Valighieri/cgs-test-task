package com.example.cgstest.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBusRouteRequest {
    @NotBlank
    private String routeName;

    @NotNull
    @Min(1)
    private Integer seatCount;
}
