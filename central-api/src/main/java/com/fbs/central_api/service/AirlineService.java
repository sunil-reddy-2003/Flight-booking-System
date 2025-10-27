package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.dto.AirlineRegistrationDto;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AirlineService {

    Mapper mapper;
    DBapiConnector dBapiConnector;

    @Autowired
    public AirlineService(Mapper mapper,DBapiConnector dBapiConnector){
        this.mapper=mapper;
        this.dBapiConnector=dBapiConnector;
    }

    private static final Logger log = LoggerFactory.getLogger(AirlineService.class);

    public void registerAirline(AirlineRegistrationDto airlineRegistrationDto){
        log.info("airlineService registerAirline method called"+airlineRegistrationDto.toString());

        AppUser airlineAdmin= mapper.mapAirlineDetailsDtoToAppUser(airlineRegistrationDto);

        log.info("Calling dbApiConnector callCreateUserMethod  with payload: "+airlineAdmin.toString());

        airlineAdmin=dBapiConnector.callCreateUserEndpoint(airlineAdmin);


    }
}
