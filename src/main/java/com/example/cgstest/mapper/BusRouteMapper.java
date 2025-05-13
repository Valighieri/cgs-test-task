package com.example.cgstest.mapper;

import com.example.cgstest.model.domain.BusRoute;
import com.example.cgstest.model.dto.BusRouteDto;
import com.example.cgstest.model.dto.CreateBusRouteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusRouteMapper {
    BusRoute toEntity(CreateBusRouteRequest req);

    BusRouteDto toDto(BusRoute route);
}

