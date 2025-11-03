package com.fbs.notification_api.dto;

public class AirlineRejectDto {
    String airlineAdminName;
    String airlineAdminEmail;
    String rejectReason;

    public AirlineRejectDto() {
    }

    public AirlineRejectDto(String airlineAdminName, String airlineAdminEmail, String rejectReason) {
        this.airlineAdminName = airlineAdminName;
        this.airlineAdminEmail = airlineAdminEmail;
        this.rejectReason = rejectReason;
    }

    public String getAirlineAdminName() {
        return airlineAdminName;
    }

    public void setAirlineAdminName(String airlineAdminName) {
        this.airlineAdminName = airlineAdminName;
    }

    public String getAirlineAdminEmail() {
        return airlineAdminEmail;
    }

    public void setAirlineAdminEmail(String airlineAdminEmail) {
        this.airlineAdminEmail = airlineAdminEmail;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public String toString() {
        return "AirlineRejectDto{" +
                "airlineAdminName='" + airlineAdminName + '\'' +
                ", airlineAdminEmail='" + airlineAdminEmail + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                '}';
    }
}
