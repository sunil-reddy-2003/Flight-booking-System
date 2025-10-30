package com.fbs.central_api.service;

import com.fbs.central_api.connectors.DBapiConnector;
import com.fbs.central_api.enums.UserType;
import com.fbs.central_api.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    DBapiConnector dbApiConnector;

    @Autowired
    public UserService(DBapiConnector dbApiConnector){

        this.dbApiConnector = dbApiConnector;
    }

    /*
        Work of this function is get all system admins from our users table.
         */
    public List<AppUser> getAllSystemAdmins(){
        // To get all the system admin from the user table we need to call db api connector
        return dbApiConnector.callGetAllUsersByUserType(UserType.SYSTEM_ADMIN.toString());
    }
}
