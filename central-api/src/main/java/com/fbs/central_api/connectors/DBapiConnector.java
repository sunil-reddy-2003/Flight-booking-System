package com.fbs.central_api.connectors;

import com.fbs.central_api.dto.AllUsersDto;
import com.fbs.central_api.exceptions.NoSystemAdminsFoundException;
import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DBapiConnector {

    RestTemplate restTemplate;

    @Autowired
    public DBapiConnector(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private static final Logger log = LoggerFactory.getLogger(DBapiConnector.class);

    @Value("${db.api.url}")
    String dbApiBaseurl; // pick value from app. properties

    public AppUser callCreateUserEndpoint(AppUser user ){
        log.info("Inside callCreateUserEndpoint method with user object"+user.toString());

        System.out.println("🛰 DEBUG: Sending user to DB API → " + user);

        //1. create url that you want to call
        String url=dbApiBaseurl+"/user/create";

        //2.we want to tell which REST method we want use and what request body we want to pass
        RequestEntity request= RequestEntity.post(url).body(user);

        log.info("Created request{}", request.toString());

        //3.hit or make the request on postman to do this step. we hit send button
        //but, here we are going to use the REST template
        RestTemplate restTemplate=new RestTemplate();
        //send BUTTON(postman) --> exchange method of rest template
        log.info("Calling dbApi to create  user endpoint");

       ResponseEntity<AppUser> response= restTemplate.exchange(url, HttpMethod.POST,request,AppUser.class);
       log.info("Response:{}",response.toString());

        return response.getBody();
    }

    public Airline callCreateAirlineEndpoint(Airline airline){

        log.info("Inside callCreateAirlineEndpoint method with airline object "+airline.toString());
        String url=dbApiBaseurl+"/airline/create";

        RequestEntity request=RequestEntity.post(url).body(airline);

        log.info("Calling dbApi to create airline endpoint");

        RestTemplate restTemplate= new RestTemplate();

        ResponseEntity<Airline> response=restTemplate.exchange(url,HttpMethod.POST,request, Airline.class);

        log.info("Response:{}",response.toString());

        return response.getBody();

    }

    /*
    This function will make request to db-api callGetAllUsersByUserType endpoint such that we will get all the system admins from the users table.
     */


    public List<AppUser> callGetAllUsersByUserType(String userType) {
        // Do, we have any this kind of endpoint developed in DB Api

        String url = dbApiBaseurl + "/user/get/" + userType;

        RequestEntity request = RequestEntity.get(url).build();

        ResponseEntity<AllUsersDto> resp =
                restTemplate.exchange(url, HttpMethod.GET, request, AllUsersDto.class);

        // NULL check
        if (resp.getBody() == null || resp.getBody().getAppUsers() == null) {
            throw new NoSystemAdminsFoundException("SYSTEM_ADMIN list is null.");
        }

        List<AppUser> admins = resp.getBody().getAppUsers();

        // EMPTY LIST check
        if (admins.isEmpty()) {
            throw new NoSystemAdminsFoundException("No SYSTEM_ADMIN users found in the system.");
        }

        return admins;
    }


}
