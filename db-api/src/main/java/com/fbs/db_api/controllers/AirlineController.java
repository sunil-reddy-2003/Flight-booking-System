package com.fbs.db_api.controllers;

import com.fbs.db_api.models.AirLine;
import com.fbs.db_api.repositories.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/airline")
public class AirlineController {

    AirlineRepository airlineRepository;

    @Autowired
    public AirlineController(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    @PostMapping("/create")
    public ResponseEntity createAirline(@RequestBody AirLine airLine){
        AirLine airlineResp = airlineRepository.save(airLine);
        return new ResponseEntity(airlineResp,HttpStatus.CREATED);
    }

    @GetMapping("/{airlineId}")
    public ResponseEntity getAirlineById(@PathVariable UUID airlineId){
        AirLine airLine= airlineRepository.findById(airlineId).orElse(null);
        return new ResponseEntity(airLine,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity  update(@RequestBody AirLine airLine){
        return new ResponseEntity(airlineRepository.save(airLine),HttpStatus.OK);
    }


}
