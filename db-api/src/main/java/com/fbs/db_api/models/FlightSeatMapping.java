package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

/*
this flight seat mapping will be used for only non-connecting flights
 */
@Entity
@Table(name = "flightseatmapping")
public class FlightSeatMapping extends SeatMapping{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    Flight flight;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public FlightSeatMapping() {
    }

    public FlightSeatMapping(UUID id, Flight flight, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.flight = flight;
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
        return "FlightSeatMapping{" +
                "id=" + id +
                ", flight=" + flight +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", className='" + className + '\'' +
                ", range='" + range + '\'' +
                ", basePrice=" + basePrice +
                ", windowPrice=" + windowPrice +
                ", totalWindow=" + totalWindow +
                '}';
    }
}
