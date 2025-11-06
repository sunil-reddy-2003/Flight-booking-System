package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.dto.AircraftRegistrationDto;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.exceptions.UnAuthorizedException;
import com.fbs.central_api.models.Aircraft;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AircraftService {

    private static final Logger log = LoggerFactory.getLogger(AircraftService.class);
    UserService userService;
    AirlineService airlineService;
    Mapper mapper;
    DBapiConnector dBapiConnector;

    @Autowired
    public AircraftService(UserService userService,
                           AirlineService airlineService,
                           Mapper mapper,
                           DBapiConnector dBapiConnector) {
        this.userService = userService;
        this.airlineService=airlineService;
        this.mapper=mapper;
        this.dBapiConnector=dBapiConnector;
    }


    public Aircraft registerAircraft(AircraftRegistrationDto aircraftRegistrationDto, String authorization){
        String token = authorization.substring(7);
        AppUser airlineAdmin = userService.getUserFromToken(token);
        if(!airlineAdmin.getUserType().equals(UserType.AIRLINE_ADMIN.toString())){
            throw new UnAuthorizedException(airlineAdmin.getUserType()+" is not allowed to register aircraft");
        }

        Airline airline=airlineService.getAirlineByAdminId(airlineAdmin.getId());
        log.info("Fetched airline for admin {}: {}", airlineAdmin.getEmail(), airline);


        Aircraft aircraft=mapper.mapAircraftDtoToAircraft(aircraftRegistrationDto,airline);
        log.info("Mapped aircraft with airline: {}", aircraft);

        return saveAircraft(aircraft);
    }

    public Aircraft saveAircraft(Aircraft aircraft){
        return dBapiConnector.callSaveAircraftEndpoint(aircraft);
    }

    public Aircraft getAircraftById(UUID aircraftId){
        return dBapiConnector.callGetAircraftByIdEndpoint(aircraftId);
    }
}
