package com.fbs.central_api.dto;


import java.time.LocalDateTime;
import java.util.List;

public class SubFlightDto {
    int priority;
    String sourceAirport;
    String destinationAirport;
    LocalDateTime boardingTime;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    int boardingMinutes;
    List<SeatMappingDto> seatMappingDtos;

    public SubFlightDto() {
    }

    public SubFlightDto(int priority, String sourceAirport, String destinationAirport, LocalDateTime boardingTime, LocalDateTime departureTime, LocalDateTime arrivalTime, int boardingMinutes, List<SeatMappingDto> seatMappingDtos) {
        this.priority = priority;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.boardingTime = boardingTime;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.boardingMinutes = boardingMinutes;
        this.seatMappingDtos = seatMappingDtos;
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

    public List<SeatMappingDto> getSeatMappingDtos() {
        return seatMappingDtos;
    }

    public void setSeatMappingDtos(List<SeatMappingDto> seatMappingDtos) {
        this.seatMappingDtos = seatMappingDtos;
    }

    @Override
    public String toString() {
        return "SubFlightDto{" +
                "priority=" + priority +
                ", sourceAirport='" + sourceAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", boardingTime=" + boardingTime +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", boardingMinutes=" + boardingMinutes +
                ", seatMappingDtos=" + seatMappingDtos +
                '}';
    }
}