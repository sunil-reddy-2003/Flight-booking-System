package com.fbs.central_api.service;

import com.fbs.central_api.connectors.NotificationApiConnector;
import com.fbs.central_api.controllers.AirlineController;
import com.fbs.central_api.dto.AirlineRegistrationReqDto;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MailService {

    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    NotificationApiConnector notificationApiConnector;

    @Autowired
    public MailService(NotificationApiConnector notificationApiConnector){
        this.notificationApiConnector = notificationApiConnector;
    }

    /*
    This function is responsible for sending mail to all the system admins regarding airline registration
     */
    public void mailSystemAdminForAirlineRegistration(List<AppUser> systemAdmins, Airline airline){

        log.info("📩 Preparing to mail {} system admins for airline {}", systemAdmins.size(), airline.getAirlineName());

        // We will apply one loop over all the system admins and one by one we will mail all the system admins
        for(AppUser systemAdmin: systemAdmins){
            // We need to call Notification api one by one for all the system admins
            // So, to call notification api from central api we require -> Notification APi connector class

            log.info("➡️  Notifying admin: {}", systemAdmin.getEmail());

            AirlineRegistrationReqDto airlineRegistrationReqDto = new AirlineRegistrationReqDto();
            airlineRegistrationReqDto.setAirline(airline);
            airlineRegistrationReqDto.setAppAdmin(systemAdmin);
            try{
                notificationApiConnector.notifySystemAdminForAirlineRegistration(airlineRegistrationReqDto);
            }catch (Exception e){
                log.error("❌ Failed to notify admin {}: {}", systemAdmin.getEmail(), e.getMessage());
            }

        }
    }

}
