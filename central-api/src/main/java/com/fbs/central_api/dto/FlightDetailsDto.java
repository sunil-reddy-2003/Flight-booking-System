package com.fbs.central_api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class FlightDetailsDto {

    UUID airlineId;
    String sourceAirport;
    String destinationAirport;
    String flightType;
    int totalTime;
    LocalDateTime boardingTime;
    int boardingMinutes;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    boolean isConnecting;
    UUID airCraftId;
    List<SubFlightDto> subFlightDtos;
    List<SeatMappingDto> seatMappingDtos;


    public FlightDetailsDto() {
    }

    public FlightDetailsDto(UUID airlineId, String sourceAirport, String destinationAirport, String flightType, int totalTime, LocalDateTime boardingTime, int boardingMinutes, LocalDateTime departureTime, LocalDateTime arrivalTime, boolean isConnecting, UUID airCraftId, List<SubFlightDto> subFlightDtos, List<SeatMappingDto> seatMappingDtos) {
        this.airlineId = airlineId;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.flightType = flightType;
        this.totalTime = totalTime;
        this.boardingTime = boardingTime;
        this.boardingMinutes = boardingMinutes;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.isConnecting = isConnecting;
        this.airCraftId = airCraftId;
        this.subFlightDtos = subFlightDtos;
        this.seatMappingDtos = seatMappingDtos;
    }



    public UUID getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(UUID airlineId) {
        this.airlineId = airlineId;
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

    public UUID getAirCraftId() {
        return airCraftId;
    }

    public void setAirCraftId(UUID airCraftId) {
        this.airCraftId = airCraftId;
    }

    public List<SubFlightDto> getSubFlightDtos() {
        return subFlightDtos;
    }

    public void setSubFlightDtos(List<SubFlightDto> subFlightDtos) {
        this.subFlightDtos = subFlightDtos;
    }

    public List<SeatMappingDto> getSeatMappingDtos() {
        return seatMappingDtos;
    }

    public void setSeatMappingDtos(List<SeatMappingDto> seatMappingDtos) {
        this.seatMappingDtos = seatMappingDtos;
    }

    @Override
    public String toString() {
        return "FlightDetailsDto{" +
                "airlineId=" + airlineId +
                ", sourceAirport='" + sourceAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", flightType='" + flightType + '\'' +
                ", totalTime=" + totalTime +
                ", boardingTime=" + boardingTime +
                ", boardingMinutes=" + boardingMinutes +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", isConnecting=" + isConnecting +
                ", airCraftId=" + airCraftId +
                ", subFlightDtos=" + subFlightDtos +
                ", seatMappingDtos=" + seatMappingDtos +
                '}';
    }
}
