package com.fbs.central_api.connectors;

import com.fbs.central_api.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class DBapiConnector {

    private static final Logger log = LoggerFactory.getLogger(DBapiConnector.class);
    @Value("${db.api.url}")
    String dbApiBaseurl; // pick value from app. properties

    public AppUser callCreateUserEndpoint(AppUser user ){
        log.info("Insed callCreateUserEndpoint method with user object"+user.toString());

        //1. create url that you want to call
        String url=dbApiBaseurl+"/user/create";

        //2.we want to tell which REST method we want use and what request body we want to pass
        RequestEntity request= RequestEntity.post(url).body(user);

        log.info("Created request"+request.toString());

        //3.hit or make the request on postman to do this step. we hit send button
        //but, here we are going to use the REST template
        RestTemplate restTemplate=new RestTemplate();
        //send BUTTON(postman) --> exchange method of rest template
        log.info("Calling dbApi create  user endpoint");

       ResponseEntity<AppUser> response= restTemplate.exchange(url, HttpMethod.POST,request,AppUser.class);
       log.info("Response: "+response.toString());

        return response.getBody();
    }

}
