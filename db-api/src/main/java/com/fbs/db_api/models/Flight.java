package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    AirLine airLine;

    @ManyToOne
    AirCraft airCraft;

    String sourceAirport;

    String destinationAirport;

    String flightType; //international or domestic or emergency

    int totalTime; //in minutes

    LocalDateTime boardingTime; //entering time into the aircraft
    int boardingMinutes;
    LocalDateTime departureTime; //take off time
    LocalDateTime arrivalTime;  //landing time

    boolean isConnecting;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Flight() {
    }

    public Flight(UUID id, AirLine airLine, AirCraft airCraft, String sourceAirport, String destinationAirport, String flightType, int totalTime, LocalDateTime boardingTime, int boardingMinutes, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean isConnecting, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.airLine = airLine;
        this.airCraft = airCraft;
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

    public AirLine getAirLine() {
        return airLine;
    }

    public void setAirLine(AirLine airLine) {
        this.airLine = airLine;
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
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
                ", airLine=" + airLine +
                ", airCraft=" + airCraft +
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
