package com.fbs.central_api.controllers;

import com.fbs.central_api.dto.AircraftRegistrationDto;
import com.fbs.central_api.dto.AirlineRegistrationDto;
import com.fbs.central_api.dto.FlightDetailsDto;
import com.fbs.central_api.models.Aircraft;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.Flight;
import com.fbs.central_api.service.AircraftService;
import com.fbs.central_api.service.AirlineService;
import com.fbs.central_api.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/airline")
public class AirlineController {

    private static final Logger log = LoggerFactory.getLogger(AirlineController.class);

    AirlineService airlineService;
    AircraftService aircraftService;
    FlightService flightService;

    @Autowired
    public AirlineController(AirlineService airlineService,
                             AircraftService aircraftService,
                             FlightService flightService) {
        this.airlineService=airlineService;
        this.aircraftService=aircraftService;
        this.flightService=flightService;
    }

    @PostMapping("/register")
    public ResponseEntity registerAirline(@RequestBody AirlineRegistrationDto airlineDetails){
        log.info("inside registerAirline method with the airlineDetails object: {}", airlineDetails.toString());
        log.info("calling airlineService registerAirline method");

        Airline airline=airlineService.registerAirline(airlineDetails);

        return new ResponseEntity(airline, HttpStatus.CREATED);
    }

    @GetMapping("/request/accept/{airlineId}")
    public void acceptAirlineRequest(@PathVariable UUID airlineId){
        log.info("acceptAirlineRequest with airline id:{}",airlineId.toString());

        airlineService.acceptAirlineRequest(airlineId);
    }

    @GetMapping("/request/reject/{airlineId}")
    public void rejectAirlineRequest(@PathVariable UUID airlineId){
        log.info("rejectAirlineRequest airline id:{}",airlineId.toString());
        airlineService.rejectAirlineRequest(airlineId);
    }

    @PostMapping("/aircraft/register")
    public Aircraft registerAircraft(@RequestBody AircraftRegistrationDto aircraftRegistrationDto,
                                     @RequestHeader String Authorization){
        log.info("registerAircraft with aircraftRegistrationDto :{}",aircraftRegistrationDto.toString());
        log.info("Authorization :{}",Authorization);
        return aircraftService.registerAircraft(aircraftRegistrationDto,Authorization);
    }

    @PostMapping("/flight/create")
    public Flight createFlight(@RequestBody FlightDetailsDto flightDetailsDto, @RequestHeader String authorization){
        System.out.println("inside /flight/create "+flightDetailsDto.toString());
        return flightService.createFlight(flightDetailsDto,authorization);
    }
}
