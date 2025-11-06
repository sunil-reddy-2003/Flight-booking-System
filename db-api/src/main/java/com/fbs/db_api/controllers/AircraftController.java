package com.fbs.db_api.controllers;

import com.fbs.db_api.models.Aircraft;
import com.fbs.db_api.repositories.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/aircraft")
public class AircraftController {

    AircraftRepo aircraftRepo;

    @Autowired
    public AircraftController(AircraftRepo aircraftRepo) {
        this.aircraftRepo = aircraftRepo;
    }

    @PostMapping("/save")
    public Aircraft saveAircraft(@RequestBody Aircraft airCraft){
        return aircraftRepo.save(airCraft);
    }


    @GetMapping("/{aircraftId}")
    public Aircraft getAircraftById(@PathVariable UUID aircraftId){
        if(aircraftRepo.findById(aircraftId).isPresent()){
            return aircraftRepo.findById(aircraftId).get();
        }
        else throw new RuntimeException("Aircraft not found");
    }
}
