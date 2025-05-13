package com.example.cgstest.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBookingRequest {
    @NotBlank
    private String passengerFirstName;

    @NotBlank
    private String passengerLastName;
}
