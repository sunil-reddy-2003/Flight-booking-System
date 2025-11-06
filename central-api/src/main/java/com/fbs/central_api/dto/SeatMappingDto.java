package com.fbs.central_api.dto;

import java.time.LocalDateTime;

public class SeatMappingDto {

    private String className;
    private String range; // e.g., 1–20
    private int basePrice;
    private int windowPrice;
    private int totalWindow;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SeatMappingDto() {
    }

    public SeatMappingDto(String className, String range, int basePrice, int windowPrice, int totalWindow,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.className = className;
        this.range = range;
        this.basePrice = basePrice;
        this.windowPrice = windowPrice;
        this.totalWindow = totalWindow;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getWindowPrice() {
        return windowPrice;
    }

    public void setWindowPrice(int windowPrice) {
        this.windowPrice = windowPrice;
    }

    public int getTotalWindow() {
        return totalWindow;
    }

    public void setTotalWindow(int totalWindow) {
        this.totalWindow = totalWindow;
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
        return "SeatMappingDto{" +
                "className='" + className + '\'' +
                ", range='" + range + '\'' +
                ", basePrice=" + basePrice +
                ", windowPrice=" + windowPrice +
                ", totalWindow=" + totalWindow +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
