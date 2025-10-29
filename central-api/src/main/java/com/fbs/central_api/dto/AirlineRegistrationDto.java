package com.fbs.central_api.dto;



public class AirlineRegistrationDto {

    String website;
    String airlineName;
    String companyName;
    int employees;
    int totalFlights;
    String email;
    String password;
    long contactNumber;

    public AirlineRegistrationDto(String website, String airlineName, String companyName, int employees, int totalFlights, String email, String password, long contactNumber) {
        this.website = website;
        this.airlineName = airlineName;
        this.companyName = companyName;
        this.employees = employees;
        this.totalFlights = totalFlights;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public AirlineRegistrationDto() {
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "AirlineRegistrationDto{" +
                "website='" + website + '\'' +
                ", airlineName='" + airlineName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", employees=" + employees +
                ", totalFlights=" + totalFlights +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
