package com.fbs.central_api.dto;

import java.time.LocalDate;

public class AircraftRegistrationDto {
    int modelNumber;
    String manufacturer;
    String modelName;
    int totalFlights;
    LocalDate buildDate;
    int capacity;

    public AircraftRegistrationDto() {
    }

    public AircraftRegistrationDto(int modelNumber, String manufacturer, String modelName, int totalFlights, LocalDate buildDate, int capacity) {
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.totalFlights = totalFlights;
        this.buildDate = buildDate;
        this.capacity = capacity;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getTotalFlights() {
        return totalFlights;
    }

    public void setTotalFlights(int totalFlights) {
        this.totalFlights = totalFlights;
    }

    public LocalDate getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(LocalDate buildDate) {
        this.buildDate = buildDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "AircraftRegistrationDto{" +
                "modelNumber=" + modelNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", totalFlights=" + totalFlights +
                ", buildDate=" + buildDate +
                ", capacity=" + capacity +
                '}';
    }
}
