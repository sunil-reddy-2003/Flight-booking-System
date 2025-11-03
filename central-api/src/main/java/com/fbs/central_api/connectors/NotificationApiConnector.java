package com.fbs.central_api.connectors;

import com.fbs.central_api.dto.AirlineRegistrationReqDto;
import com.fbs.central_api.dto.AirlineRejectDto;
import com.fbs.central_api.models.Airline;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class NotificationApiConnector {

    private static final Logger log = LoggerFactory.getLogger(NotificationApiConnector.class);


    RestTemplate restTemplate;

    @Autowired
    public NotificationApiConnector(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${notification.api.url}")
    String notificationBaseUrl;

    public void notifySystemAdminForAirlineRegistration(AirlineRegistrationReqDto airlineRegistrationReqDto){
        log.info("Inside notifySystemAdminForAirlineRegistration → {}", airlineRegistrationReqDto);
        String url = notificationBaseUrl + "/appadmin/airline-registration";

        try {
            RequestEntity<AirlineRegistrationReqDto> request = RequestEntity.post(url).body(airlineRegistrationReqDto);
            log.info("📤 Calling Notification API at: {}", url);

            ResponseEntity<String> resp = restTemplate.exchange(request, String.class);

            log.info("✅ Notification API response: {}", resp.getStatusCode());

        } catch (Exception e) {
            log.error("❌ Error while calling Notification API: {}", e.getMessage(), e);
        }
    }

    public void notifyAcceptRequestToAirlineAdmin(Airline airline){
        String url = notificationBaseUrl+"/airline/admin/accept-request";
        RequestEntity airlineRequest=RequestEntity.put(url).body(airline);
        log.info("📤📤📤 Calling Notification API at: {}", url);
        ResponseEntity<Object> response=restTemplate.exchange(url,HttpMethod.PUT,airlineRequest,Object.class);
        log.info("✅✅✅ Accept Notification API response: {}", response.getStatusCode());
    }

    public void notifyRejectRequestToAirlineAdmin(AirlineRejectDto airlineRejectDto){
        String url= notificationBaseUrl+"/airline/admin/reject-request";
        RequestEntity airlineRequest=RequestEntity.put(url).body(airlineRejectDto);
        log.info("❌❌❌ Calling reject Notification API at: {}", url);
        ResponseEntity<Object> response=restTemplate.exchange(url,HttpMethod.PUT,airlineRequest,Object.class);
        log.info("✅✅✅ Reject Notification API response: {}", response.getStatusCode());



    }
}
