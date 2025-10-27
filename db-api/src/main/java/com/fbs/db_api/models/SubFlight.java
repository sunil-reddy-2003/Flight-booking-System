package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class SubFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    Flight flight;
    int priority;

    String sourceAirport;
    String destinationAirport;

    LocalDateTime boardingTime; //entering time into the aircraft
    LocalDateTime departureTime; //take off time
    LocalDateTime arrivalTime;  //landing time
    int boardingMinutes;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public SubFlight(UUID id, Flight flight, int priority, String sourceAirport, String destinationAirport, LocalDateTime boardingTime, LocalDateTime departureTime, LocalDateTime arrivalTime, int boardingMinutes, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.flight = flight;
        this.priority = priority;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.boardingTime = boardingTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.boardingMinutes = boardingMinutes;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SubFlight() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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

    public LocalDateTime getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(LocalDateTime boardingTime) {
        this.boardingTime = boardingTime;
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

    public int getBoardingMinutes() {
        return boardingMinutes;
    }

    public void setBoardingMinutes(int boardingMinutes) {
        this.boardingMinutes = boardingMinutes;
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
        return "SubFlight{" +
                "id=" + id +
                ", flight=" + flight +
                ", priority=" + priority +
                ", sourceAirport='" + sourceAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", boardingTime=" + boardingTime +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", boardingMinutes=" + boardingMinutes +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
