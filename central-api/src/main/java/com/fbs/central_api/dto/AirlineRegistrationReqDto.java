package com.fbs.central_api.dto;


import com.fbs.central_api.models.Airline;
import com.fbs.central_api.models.AppUser;

public class AirlineRegistrationReqDto {
    AppUser appAdmin;
    Airline airline;

    public AirlineRegistrationReqDto() {
    }

    public AirlineRegistrationReqDto(AppUser appAdmin, Airline airline) {
        this.appAdmin = appAdmin;
        this.airline = airline;
    }

    public AppUser getAppAdmin() {
        return appAdmin;
    }

    public void setAppAdmin(AppUser appAdmin) {
        this.appAdmin = appAdmin;
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
                "appAdmin=" + appAdmin +
                ", airline=" + airline +
                '}';
    }
}