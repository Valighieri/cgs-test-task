package com.example.cgstest.service;

import com.example.cgstest.mapper.BusRouteMapper;
import com.example.cgstest.model.domain.BusRoute;
import com.example.cgstest.model.domain.Seat;
import com.example.cgstest.model.domain.SeatId;
import com.example.cgstest.model.dto.BusRouteDto;
import com.example.cgstest.model.dto.CreateBusRouteRequest;
import com.example.cgstest.repository.BusRouteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusRouteService {
    private final BusRouteRepository busRouteRepository;
    private final BusRouteMapper busRouteMapper;

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
}

