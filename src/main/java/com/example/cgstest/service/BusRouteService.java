package com.example.cgstest.service;

import com.example.cgstest.mapper.BusRouteMapper;
import com.example.cgstest.mapper.SeatMapper;
import com.example.cgstest.model.domain.BusRoute;
import com.example.cgstest.model.domain.Seat;
import com.example.cgstest.model.domain.SeatId;
import com.example.cgstest.model.dto.BusRouteDto;
import com.example.cgstest.model.dto.CreateBusRouteRequest;
import com.example.cgstest.model.dto.SeatStatusDto;
import com.example.cgstest.repository.BusRouteRepository;
import com.example.cgstest.repository.SeatRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusRouteService {
    private final BusRouteRepository busRouteRepository;
    private final SeatRepository seatRepository;
    private final BusRouteMapper busRouteMapper;
    private final SeatMapper seatMapper;

    @Transactional
    public BusRouteDto createRoute(CreateBusRouteRequest req) {

        BusRoute route = busRouteMapper.toEntity(req);

        for (int num = 1; num <= req.getSeatCount(); num++) {
            Seat seat = new Seat();
            seat.setId(new SeatId(null, num));
            route.addSeat(seat);
        }

        BusRoute saved = busRouteRepository.save(route);
        return busRouteMapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public List<SeatStatusDto> listSeats(Long routeId) {
        BusRoute route = busRouteRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "BusRoute not found: " + routeId));

        return route.getSeats().stream()
                .map(seatMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void cancelBooking(Long routeId, Integer seatNumber) {
        SeatId id = new SeatId(routeId, seatNumber);
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Seat " + seatNumber + " on route " + routeId + " not found"));

        if (seat.getBooking() == null) {
            throw new IllegalStateException(
                    "Seat " + seatNumber + " on route " + routeId + " is not booked");
        }

        seat.setBooking(null);
        seat.setBookable(true);

        seatRepository.save(seat);
    }
}

