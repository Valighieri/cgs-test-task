package com.example.cgstest.mapper;

import com.example.cgstest.model.domain.Seat;
import com.example.cgstest.model.dto.SeatStatusDto;
import com.example.cgstest.model.enums.SeatStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeatMapper {

    @Mapping(target = "seatNumber", source = "id.seatNumber")
    @Mapping(target = "status", expression = "java(determineStatus(seat))")
    SeatStatusDto toDto(Seat seat);

    default SeatStatus determineStatus(Seat seat) {
        if (!seat.isBookable()) {
            return SeatStatus.UNAVAILABLE;
        }
        return seat.getBooking() == null
                ? SeatStatus.AVAILABLE
                : SeatStatus.BOOKED;
    }
}
