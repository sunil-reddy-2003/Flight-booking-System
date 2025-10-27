package com.fbs.central_api.models;


import java.time.LocalDateTime;
import java.util.UUID;


public class Airline {

    UUID id;
    String website;
    String email;
    String airlineName;
    String companyName;
    int employees;
    int totalFlights;
    AppUser admin;

    String status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Airline(UUID id, String website, String email, String airlineName, String companyName, int employees, int totalFlights, AppUser admin, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.website = website;
        this.email = email;
        this.airlineName = airlineName;
        this.companyName = companyName;
        this.employees = employees;
        this.totalFlights = totalFlights;
        this.admin = admin;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Airline() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getTotalFlights() {
        return totalFlights;
    }

    public void setTotalFlights(int totalFlights) {
        this.totalFlights = totalFlights;
    }

    public AppUser getAdmin() {
        return admin;
    }

    public void setAdmin(AppUser admin) {
        this.admin = admin;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", website='" + website + '\'' +
                ", email='" + email + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", employees=" + employees +
                ", totalFlights=" + totalFlights +
                ", admin=" + admin +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
