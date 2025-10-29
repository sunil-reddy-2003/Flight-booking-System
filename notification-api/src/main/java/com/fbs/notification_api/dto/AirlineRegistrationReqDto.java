package com.fbs.notification_api.dto;

import com.fbs.notification_api.models.Airline;
import com.fbs.notification_api.models.AppUser;

public class AirlineRegistrationReqDto {
    AppUser admin;
    Airline airline;

    public AirlineRegistrationReqDto() {
    }

    public AirlineRegistrationReqDto(AppUser admin, Airline airline) {
        this.admin = admin;
        this.airline = airline;
    }

    public AppUser getAdmin() {
        return admin;
    }

    public void setAdmin(AppUser admin) {
        this.admin = admin;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "AirlineRegistrationReqDto{" +
                "admin=" + admin +
                ", airline=" + airline +
                '}';
    }
}
