package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

/*
this table is strictly used for non-connecting flights
 */

@Entity
@Table(name = "flightbookedseats")
public class FlightSeatBooked extends SeatBooked{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    Flight flight;

    @ManyToOne
    AppUser bookedBy;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public FlightSeatBooked() {
    }

    public FlightSeatBooked(UUID id, Flight flight, AppUser bookedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.flight = flight;
        this.bookedBy = bookedBy;
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

    public AppUser getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(AppUser bookedBy) {
        this.bookedBy = bookedBy;
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
        return "FlightSeatBooked{" +
                "id=" + id +
                ", flight=" + flight +
                ", bookedBy=" + bookedBy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", passengerName='" + passengerName + '\'' +
                ", above18=" + above18 +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
