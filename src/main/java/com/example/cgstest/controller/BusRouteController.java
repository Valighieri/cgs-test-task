package com.example.cgstest.controller;

import com.example.cgstest.model.dto.BookingDto;
import com.example.cgstest.model.dto.BusRouteDto;
import com.example.cgstest.model.dto.CreateBookingRequest;
import com.example.cgstest.model.dto.CreateBusRouteRequest;
import com.example.cgstest.model.dto.SeatStatusDto;
import com.example.cgstest.service.BookingService;
import com.example.cgstest.service.BusRouteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bus-routes")
@RequiredArgsConstructor
public class BusRouteController {
    private final BusRouteService busRouteService;
    private final BookingService bookingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BusRouteDto create(@RequestBody @Valid CreateBusRouteRequest req) {
        return busRouteService.createRoute(req);
    }

    @PostMapping("/{routeId}/seats/{seatNumber}/booking")
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDto bookSeat(
            @PathVariable Long routeId,
            @PathVariable Integer seatNumber,
            @RequestBody @Valid CreateBookingRequest req
    ) {
        return bookingService.bookSeat(routeId, seatNumber, req);
    }

    @GetMapping("/{routeId}/seats")
    public List<SeatStatusDto> listSeats(
            @PathVariable Long routeId
    ) {
        return busRouteService.listSeats(routeId);
    }
}

