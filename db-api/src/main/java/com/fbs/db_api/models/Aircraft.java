package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "aircrafts")
public class Aircraft {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int modelNumber;
    String manufacturer;
    String modelName;
    int totalFlights;
    LocalDate buildDate;
    @ManyToOne
    Airline airline;
    int capacity;

    public Aircraft() {
    }

    public Aircraft(UUID id, int modelNumber, String manufacturer, String modelName, int totalFlights, LocalDate buildDate, Airline airline, int capacity) {
        this.id = id;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.totalFlights = totalFlights;
        this.buildDate = buildDate;
        this.airline = airline;
        this.capacity = capacity;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "id=" + id +
                ", modelNumber=" + modelNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", totalFlights=" + totalFlights +
                ", buildDate=" + buildDate +
                ", airline=" + airline +
                ", capacity=" + capacity +
                '}';
    }
}
