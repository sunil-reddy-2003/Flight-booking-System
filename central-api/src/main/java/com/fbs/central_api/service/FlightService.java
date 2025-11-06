package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.dto.FlightDetailsDto;
import com.fbs.central_api.dto.SeatMappingDto;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.exceptions.UnAuthorizedException;
import com.fbs.central_api.models.*;
import com.fbs.central_api.utility.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FlightService  {


    private static final Logger log = LoggerFactory.getLogger(FlightService.class);
    UserService userService;
    Mapper mapper;
    AirlineService airlineService;
    AircraftService aircraftService;
    DBapiConnector dBapiConnector;
    @Autowired
    public FlightService(UserService userService,
                         Mapper mapper,
                         AirlineService airlineService,
                         AircraftService aircraftService,
                         DBapiConnector dBapiConnector) {
        this.userService=userService;
        this.mapper=mapper;
        this.airlineService=airlineService;
        this.aircraftService=aircraftService;
        this.dBapiConnector=dBapiConnector;
    }

    public Flight createFlight(FlightDetailsDto flightDetailsDto, String authorization){
        log.info("inside createFlight with:{}",flightDetailsDto.toString());
        String token= authorization.substring(7);

        AppUser user=userService.getUserFromToken(token);
        if (!user.getUserType().equals(UserType.AIRLINE_ADMIN.toString())) {
            throw new UnAuthorizedException(user.getUserType()+" is not allowed to create flight");
        }

        Airline airline=airlineService.getAirlineByAdminId(user.getId());
        Aircraft aircraft=aircraftService.getAircraftById(flightDetailsDto.getAirCraftId());
        Flight flight = mapper.mapFlightDetailsDtoToFLightModel(flightDetailsDto,airline,aircraft);

        flight=dBapiConnector.callCreateFlightEndPoint(flight);

        List<SeatMappingDto> seatMappingDtos=flightDetailsDto.getSeatMappingDtos();
        for (int i = 0; i < seatMappingDtos.size(); i++) {
            SeatMappingDto seatMappingDto=seatMappingDtos.get(i);
            FlightSeatMapping flightSeatMapping=mapper.mapFlightSeatMappingDtoToModel(seatMappingDto,flight);
            dBapiConnector.callCreateFlightSeatMappingEndPoint(flightSeatMapping);
        }

        return flight;
    }
}
