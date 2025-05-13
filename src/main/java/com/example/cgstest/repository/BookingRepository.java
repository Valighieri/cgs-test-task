package com.example.cgstest.repository;

import com.example.cgstest.model.domain.Booking;
import com.example.cgstest.model.domain.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, SeatId> {
}
