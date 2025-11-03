package com.fbs.notification_api.controllers;

import com.fbs.notification_api.dto.AirlineRegistrationReqDto;
import com.fbs.notification_api.service.AppAdminNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notify/appadmin")
public class AppAdminNotificationController {

    private static final Logger log = LoggerFactory.getLogger(AppAdminNotificationController.class);

    AppAdminNotificationService appAdminNotificationService;

    public AppAdminNotificationController(AppAdminNotificationService appAdminNotificationService){
        this.appAdminNotificationService=appAdminNotificationService;
    }

    @PostMapping("/airline-registration")
    public ResponseEntity airlineRegistrationRequestNotification(@RequestBody AirlineRegistrationReqDto airlineRegistrationReqDto){
        log.info("✅ Mail triggered successfully for admin {}", airlineRegistrationReqDto.getAppAdmin().getEmail());
        log.info("Inside airlineRegistrationRequestNotification with payload {}", airlineRegistrationReqDto.toString());

        appAdminNotificationService.sendAirlineRegistrationRequestNotification(airlineRegistrationReqDto);
        return ResponseEntity.ok("ok");
    }

}
