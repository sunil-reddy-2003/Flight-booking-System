package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "aircrafts")
public class AirCraft {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int modelNumber;
    String manufacturer;
    String modelName;
    int totalFlights;
    LocalDate buildDate;
    @ManyToOne
    AirLine airLine;
    int capacity;

    public AirCraft() {
    }

    public AirCraft(UUID id, int modelNumber, String manufacturer, String modelName, int totalFlights, LocalDate buildDate, AirLine airLine, int capacity) {
        this.id = id;
        this.modelNumber = modelNumber;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.totalFlights = totalFlights;
        this.buildDate = buildDate;
        this.airLine = airLine;
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

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
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
                ", airLine=" + airLine +
                ", capacity=" + capacity +
                '}';
    }
}
