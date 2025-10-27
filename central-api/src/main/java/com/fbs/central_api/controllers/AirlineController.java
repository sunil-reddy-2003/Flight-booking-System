package com.fbs.central_api.controllers;

import com.fbs.central_api.dto.AirlineRegistrationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/airline")
@Slf4j
public class AirlineController {

    @PostMapping("/register")
    public ResponseEntity registerAirline(@RequestBody AirlineRegistrationDto airlineDetails){
        System.out.println("in registerAirline methode: "+airlineDetails.toString());
    }
}
