package com.fbs.central_api.controllers;

import com.fbs.central_api.dto.AirlineRegistrationDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.service.AirlineService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/airline")
@Slf4j
public class AirlineController {

    private static final Logger log = LoggerFactory.getLogger(AirlineController.class);

    AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService=airlineService;
    }

    @PostMapping("/register")
    public ResponseEntity registerAirline(@RequestBody AirlineRegistrationDto airlineDetails){
        log.info("inside registerAirline method with the airlineDetails object: "+airlineDetails.toString());
        log.info("calling airlineService registerAirline method");

        Airline airline=airlineService.registerAirline(airlineDetails);

        return new ResponseEntity(airline, HttpStatus.CREATED);
    }
}
