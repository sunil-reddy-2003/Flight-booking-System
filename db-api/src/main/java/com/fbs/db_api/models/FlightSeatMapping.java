package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

/*
This flight seat mapping model will only be used for non-connecting flights
 */
@Entity
@Table(name = "flightseatmapping")
public class FlightSeatMapping extends SeatMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String className;
    String range; // 1-20
    int basePrice;
    int windowPrice;
    int totalWindow;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    @ManyToOne
    Flight flight;

    public FlightSeatMapping() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getWindowPrice() {
        return windowPrice;
    }

    public void setWindowPrice(int windowPrice) {
        this.windowPrice = windowPrice;
    }

    public int getTotalWindow() {
        return totalWindow;
    }

    public void setTotalWindow(int totalWindow) {
        this.totalWindow = totalWindow;
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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}