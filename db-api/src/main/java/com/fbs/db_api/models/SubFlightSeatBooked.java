package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table
public class SubFlightSeatBooked extends SeatBooked{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    SubFlight flight;

    @ManyToOne
    AppUser bookedBy;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public SubFlightSeatBooked() {
    }

    public SubFlightSeatBooked(UUID id, SubFlight flight, AppUser bookedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public SubFlight getFlight() {
        return flight;
    }

    public void setFlight(SubFlight flight) {
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
        return "SubFlightSeatBooked{" +
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
