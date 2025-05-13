package com.example.cgstest.mapper;

import com.example.cgstest.model.domain.Booking;
import com.example.cgstest.model.dto.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(target = "routeId", source = "id.busRouteId")
    @Mapping(target = "seatNumber", source = "id.seatNumber")
    BookingDto toDto(Booking booking);

}
