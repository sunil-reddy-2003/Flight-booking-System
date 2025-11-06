package com.fbs.central_api.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Flight {
    UUID id;
    Airline airline;
    Aircraft aircraft;
    String sourceAirport;
    String destinationAirport;
    String flightType;
    int totalTime;
    LocalDateTime boardingTime;
    int boardingMinutes;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    boolean isConnecting;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Flight() {
    }

    public Flight(UUID id, Airline airline, Aircraft aircraft, String sourceAirport, String destinationAirport, String flightType, int totalTime, LocalDateTime boardingTime, int boardingMinutes, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean isConnecting, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.airline = airline;
        this.aircraft = aircraft;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.flightType = flightType;
        this.totalTime = totalTime;
        this.boardingTime = boardingTime;
        this.boardingMinutes = boardingMinutes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.isConnecting = isConnecting;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public LocalDateTime getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(LocalDateTime boardingTime) {
        this.boardingTime = boardingTime;
    }

    public int getBoardingMinutes() {
        return boardingMinutes;
    }

    public void setBoardingMinutes(int boardingMinutes) {
        this.boardingMinutes = boardingMinutes;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean isConnecting() {
        return isConnecting;
    }

    public void setConnecting(boolean connecting) {
        isConnecting = connecting;
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
        return "Flight{" +
                "id=" + id +
                ", airline=" + airline +
                ", aircraft=" + aircraft +
                ", sourceAirport='" + sourceAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", flightType='" + flightType + '\'' +
                ", totalTime=" + totalTime +
                ", boardingTime=" + boardingTime +
                ", boardingMinutes=" + boardingMinutes +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", isConnecting=" + isConnecting +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
