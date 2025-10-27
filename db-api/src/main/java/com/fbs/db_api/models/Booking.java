package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @ManyToOne
    Flight flight;

    @ManyToMany
    List<SubFlight> subFlights;

    @ManyToOne
    AppUser bookedBy;

    int totalAmount;

    String passengerName;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Booking() {
    }

    public Booking(UUID id, Flight flight, List<SubFlight> subFlights, AppUser bookedBy, int totalAmount, String passengerName, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.flight = flight;
        this.subFlights = subFlights;
        this.bookedBy = bookedBy;
        this.totalAmount = totalAmount;
        this.passengerName = passengerName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public List<SubFlight> getSubFlights() {
        return subFlights;
    }

    public void setSubFlights(List<SubFlight> subFlights) {
        this.subFlights = subFlights;
    }

    public AppUser getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(AppUser bookedBy) {
        this.bookedBy = bookedBy;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
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
        return "Booking{" +
                "id=" + id +
                ", flight=" + flight +
                ", subFlights=" + subFlights +
                ", bookedBy=" + bookedBy +
                ", totalAmount=" + totalAmount +
                ", passengerName='" + passengerName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
