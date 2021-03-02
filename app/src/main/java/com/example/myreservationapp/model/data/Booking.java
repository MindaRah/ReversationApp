package com.example.myreservationapp.model.data;

public class Booking {
    private int booking_id;
    private int numberOfNights;

    public Booking(int booking_id, int numberOfNights) {
        this.booking_id = booking_id;
        this.numberOfNights = numberOfNights;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
}
