package com.example.cgstest.repository;

import com.example.cgstest.model.domain.Seat;
import com.example.cgstest.model.domain.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, SeatId> {
}
