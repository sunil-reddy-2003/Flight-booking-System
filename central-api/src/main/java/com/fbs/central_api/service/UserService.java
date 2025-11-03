package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.exceptions.InvalidCredentials;
import com.fbs.central_api.models.AppUser;
import com.fbs.central_api.utility.AuthUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    DBapiConnector dbApiConnector;
    AuthUtility authUtility;

    @Autowired
    public UserService(DBapiConnector dbApiConnector,
                       AuthUtility authUtility){

        this.dbApiConnector = dbApiConnector;
        this.authUtility=authUtility;
    }

    /*
        Work of this function is get all system admins from our users table.
         */
    public List<AppUser> getAllSystemAdmins(){
        // To get all the system admin from the user table we need to call db api connector
        return dbApiConnector.callGetAllUsersByUserType(UserType.SYSTEM_ADMIN.toString());
    }

    public AppUser updateUserDetails(AppUser user){
        return dbApiConnector.callUpdateUserEndpoint(user);
    }

    public AppUser getUserByEmail(String email){
        return dbApiConnector.callGetUserByEmailEndpoint(email);
    }

    public String isValidCredentials(String email,String password){
        AppUser user=getUserByEmail(email);
        if(user.getPassword().equals(password)){
           return authUtility.generateToken(user.getEmail(), user.getPassword(), user.getUserType());
        }
        throw new InvalidCredentials("Email or Password is wrong!!");
    }

    public boolean validateToken(String token){
        String payload = authUtility.decryptJwtToken(token);
        String [] details = payload.split(":");
        String email = details[0];
        String password = details[1];
        // I want to validate email & password is it belonging to correct user or not
        // Auth Utility is going to call UserService to validate email and password belongs to correct user or not
        try{
            isValidCredentials(email, password);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
