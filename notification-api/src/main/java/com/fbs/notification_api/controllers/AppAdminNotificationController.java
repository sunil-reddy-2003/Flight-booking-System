package com.fbs.notification_api.controllers;

import com.fbs.notification_api.dto.AirlineRegistrationReqDto;
import com.fbs.notification_api.service.AppAdminNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notify/appadmin")
@Slf4j
public class AppAdminNotificationController {

    private static final Logger log = LoggerFactory.getLogger(AppAdminNotificationController.class);

    AppAdminNotificationService appAdminNotificationService;

    public AppAdminNotificationController(AppAdminNotificationService appAdminNotificationService){
        this.appAdminNotificationService=appAdminNotificationService;
    }

    @PutMapping("/airline-registration")
    public void airlineRegistrationRequestNotification(@RequestBody AirlineRegistrationReqDto airlineRegistrationReqDto){
        log.info("Inside airlineRegistrationRequestNotification with payload "+airlineRegistrationReqDto.toString());

        appAdminNotificationService.sendAirlineRegistrationRequestNotification(airlineRegistrationReqDto);
    }

}
