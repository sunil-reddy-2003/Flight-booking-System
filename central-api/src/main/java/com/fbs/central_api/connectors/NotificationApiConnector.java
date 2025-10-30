package com.fbs.central_api.connectors;

import com.fbs.central_api.dto.AirlineRegistrationReqDto;
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
}
