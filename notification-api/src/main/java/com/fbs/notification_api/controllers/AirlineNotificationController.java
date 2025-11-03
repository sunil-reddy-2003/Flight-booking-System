package com.fbs.notification_api.controllers;

import com.fbs.notification_api.dto.AirlineRejectDto;
import com.fbs.notification_api.models.Airline;
import com.fbs.notification_api.service.AirlineNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notify/airline")
public class AirlineNotificationController {

    AirlineNotificationService airlineNotificationService;

    public AirlineNotificationController(AirlineNotificationService airlineNotificationService) {
        this.airlineNotificationService = airlineNotificationService;
    }

    @PutMapping("/admin/accept-request")
    public void airlineAdminAcceptNotification(@RequestBody Airline airline){
        log.info("✅ Mail triggered successfully for admin {}", airline.getAdmin().getEmail());
        log.info("Inside airlineAdminAcceptNotification with payload "+airline.toString());

        airlineNotificationService.airlineAcceptRequestNotification(airline);
    }

    @PutMapping("/admin/reject-request")
    public void airlineAdminRejectNotification(@RequestBody AirlineRejectDto airlineRejectDto){
        log.info("❌Rejection Mail triggered successfully for Airline admin {}", airlineRejectDto.getAirlineAdminEmail());
        airlineNotificationService.notifyAirlineAdminRejectNotification(airlineRejectDto);

    }
}
