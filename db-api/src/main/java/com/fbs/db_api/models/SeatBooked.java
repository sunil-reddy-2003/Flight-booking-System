package com.fbs.db_api.models;

public class SeatBooked {
    String passengerName;
    boolean above18;
    int seatNumber;

    public SeatBooked() {
    }

    public SeatBooked(String passengerName, boolean above18, int seatNumber) {
        this.passengerName = passengerName;
        this.above18 = above18;
        this.seatNumber = seatNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public boolean isAbove18() {
        return above18;
    }

    public void setAbove18(boolean above18) {
        this.above18 = above18;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "SeatBooked{" +
                "passengerName='" + passengerName + '\'' +
                ", above18=" + above18 +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
