package com.example.cgstest.service;

import com.example.cgstest.exception.SeatUnavailableException;
import com.example.cgstest.mapper.BookingMapper;
import com.example.cgstest.model.domain.Booking;
import com.example.cgstest.model.domain.Seat;
import com.example.cgstest.model.domain.SeatId;
import com.example.cgstest.model.dto.BookingDto;
import com.example.cgstest.model.dto.CreateBookingRequest;
import com.example.cgstest.repository.BookingRepository;
import com.example.cgstest.repository.SeatRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final SeatRepository seatRepo;
    private final BookingRepository bookingRepo;
    private final BookingMapper bookingMapper;

    @Transactional
    public BookingDto bookSeat(Long routeId, Integer seatNumber, CreateBookingRequest req) {
        SeatId id = new SeatId(routeId, seatNumber);
        Seat seat = seatRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found: " + id));

        if (!seat.isBookable() || seat.getBooking() != null) {
            throw new SeatUnavailableException("Seat is unavailable or already booked");
        }

        Booking booking = new Booking();
        booking.setPassengerFirstName(req.getPassengerFirstName());
        booking.setPassengerLastName(req.getPassengerLastName());
        seat.assignBooking(booking);

        Booking saved = bookingRepo.save(booking);
        return bookingMapper.toDto(saved);
    }

}

