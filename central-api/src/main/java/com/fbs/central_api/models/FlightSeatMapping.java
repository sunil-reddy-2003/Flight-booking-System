package com.fbs.central_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class FlightSeatMapping{

    UUID id;
    String className;
    String range; // 1-20
    int basePrice;
    int windowPrice;
    int totalWindow;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Flight flight;

    public FlightSeatMapping() {
    }

    public FlightSeatMapping(UUID id, String className, String range, int basePrice, int windowPrice, int totalWindow, LocalDateTime createdAt, LocalDateTime updatedAt, Flight flight) {
        this.id = id;
        this.className = className;
        this.range = range;
        this.basePrice = basePrice;
        this.windowPrice = windowPrice;
        this.totalWindow = totalWindow;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.flight = flight;
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

    @Override
    public String toString() {
        return "FlightSeatMapping{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", range='" + range + '\'' +
                ", basePrice=" + basePrice +
                ", windowPrice=" + windowPrice +
                ", totalWindow=" + totalWindow +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", flight=" + flight +
                '}';
    }
}
