package com.example.myreservationapp.model.data;

public class Guest {
    private int guest_id;
    private String title;
    private String firstNameOfGuest;
    private String lastNameOfGuest;
    private int numberOfGuests;
    private String phoneNumber;

    public Guest(int guest_id, String title, String firstNameOfGuest, String lastNameOfGuest, int numberOfGuests, String phoneNumber) {
        this.guest_id = guest_id;
        this.title = title;
        this.firstNameOfGuest = firstNameOfGuest;
        this.lastNameOfGuest = lastNameOfGuest;
        this.numberOfGuests = numberOfGuests;
        this.phoneNumber = phoneNumber;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstNameOfGuest() {
        return firstNameOfGuest;
    }

    public void setFirstNameOfGuest(String firstNameOfGuest) {
        this.firstNameOfGuest = firstNameOfGuest;
    }

    public String getLastNameOfGuest() {
        return lastNameOfGuest;
    }

    public void setLastNameOfGuest(String lastNameOfGuest) {
        this.lastNameOfGuest = lastNameOfGuest;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
