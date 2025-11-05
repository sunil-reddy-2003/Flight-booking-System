package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.connectors.GeminiConnector;
import com.fbs.central_api.dto.AirlineRegistrationDto;
import com.fbs.central_api.enums.AirlineStatus;
import com.fbs.central_api.enums.UserStatus;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.models.GeminiApiResponse;
import com.fbs.central_api.utility.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AirlineService {

    Mapper mapper;
    DBapiConnector dBapiConnector;
    UserService userService;
    MailService mailService;
    GeminiConnector geminiConnector;

    @Autowired
    public AirlineService(Mapper mapper,
                          DBapiConnector dBapiConnector,
                          UserService userService,
                          MailService mailService,
                          GeminiConnector geminiConnector){
        this.mapper=mapper;
        this.dBapiConnector=dBapiConnector;
        this.userService=userService;
        this.mailService=mailService;
        this.geminiConnector=geminiConnector;
    }

    private static final Logger log = LoggerFactory.getLogger(AirlineService.class);

    public  Airline getAirlineById(UUID airlineId){
        return dBapiConnector.callGetAirlineByIdEndpoint(airlineId);
    }

    public Airline updateAirlineDetails(Airline airline){
        return dBapiConnector.callUpdateAirlineEndpoint(airline);
    }

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

    public Airline acceptAirlineRequest(UUID airlineId){
        Airline airline=this.getAirlineById(airlineId); //is equivalent to Airline airline=getAirlineById(airlineId);
        airline.setStatus(AirlineStatus.ACTIVE.toString());
        airline.setUpdatedAt(LocalDateTime.now());
        airline=updateAirlineDetails(airline);

        AppUser airlineAdmin=airline.getAdmin();
        airlineAdmin.setStatus(UserStatus.ACTIVE.toString());
        airlineAdmin.setUpdatedAt(LocalDateTime.now());
        userService.updateUserDetails(airlineAdmin);
        mailService.notifyAcceptRequestToAirlineAdmin(airline);
        return  airline;
    }

    public void rejectAirlineRequest(UUID airlineId) {
        Airline airline=getAirlineById(airlineId);
        airline.setStatus(AirlineStatus.REJECTED.toString());
        updateAirlineDetails(airline);

        String prompt="Generate Failure reason fot the airline details: "+airline.toString();
        GeminiApiResponse geminiApiResponse=geminiConnector.callGeminiGenAIEndpoint(prompt);
        String result=geminiApiResponse.getCandidates().get(0).getContent().getParts().get(0).getText();

        mailService.notifyRejectRequestToAirlineAdmin(airline.getAdmin().getEmail(),airline.getAdmin().getName(),result);

    }

    public Airline getAirlineByAdminId(UUID airlineId){
        return dBapiConnector.callGetAirlineByAdminIdEndpoint(airlineId);
    }
}
