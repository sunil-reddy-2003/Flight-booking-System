package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.dto.AirlineRegistrationDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AirlineService {

    Mapper mapper;
    DBapiConnector dBapiConnector;
    UserService userService;
    MailService mailService;

    @Autowired
    public AirlineService(Mapper mapper,
                          DBapiConnector dBapiConnector,
                          UserService userService,
                          MailService mailService){
        this.mapper=mapper;
        this.dBapiConnector=dBapiConnector;
        this.userService=userService;
        this.mailService=mailService;
    }

    private static final Logger log = LoggerFactory.getLogger(AirlineService.class);

    public Airline registerAirline(AirlineRegistrationDto airlineRegistrationDto){
        log.info("airlineService registerAirline method called"+airlineRegistrationDto.toString());

        AppUser airlineAdmin= mapper.mapAirlineDetailsDtoToAppUser(airlineRegistrationDto);

        log.info("Calling dbApiConnector callCreateUserMethod  with payload: "+airlineAdmin.toString());

        airlineAdmin=dBapiConnector.callCreateUserEndpoint(airlineAdmin);

        Airline airline=mapper.mapAirlineDetailsDtoToAirlineObject(airlineRegistrationDto,airlineAdmin);

        airline=dBapiConnector.callCreateAirlineEndpoint(airline);
        log.info("Calling dbApiConnector callCreateAirlineEndpoint  with payload: "+airline.toString());

        List<AppUser> systemAdminList = userService.getAllSystemAdmins();
        // Mail all system admins
        mailService.mailSystemAdminForAirlineRegistration(systemAdminList, airline);
        return airline;

    }
}
