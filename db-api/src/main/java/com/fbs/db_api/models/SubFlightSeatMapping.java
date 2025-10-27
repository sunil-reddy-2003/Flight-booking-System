package com.fbs.db_api.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table
public class SubFlightSeatMapping extends SeatMapping{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    SubFlight flight;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public SubFlightSeatMapping() {
    }

    public SubFlightSeatMapping(UUID id, SubFlight flight, LocalDateTime createdAt, LocalDateTime updatedAt) {
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

    public SubFlight getFlight() {
        return flight;
    }

    public void setFlight(SubFlight flight) {
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
        return "SubFlightSeatMapping{" +
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
