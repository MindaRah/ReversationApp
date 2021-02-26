package com.example.myreservationapp.model.data;

import com.example.myreservationapp.util.Day;

public class Reservation {

    //integer Id
    private int id;
    private Day day;
    private double price;
    private int numberOfGuests;
    private int numberOfRoom;
    private String roomName;
    private int numberOfNights;
    private String firstNameOfGuest;
    private String lastNameOfGuest;

    public Reservation(int id, String firstNameOfGuest, String lastNameOfGuest, Day day, int numberOfGuests, int numberOfRoom, String roomName, int numberOfNights, double price) {
        this.id = id;
        this.firstNameOfGuest = firstNameOfGuest;
        this.lastNameOfGuest = lastNameOfGuest;
        this.day = day;
        this.numberOfGuests = numberOfGuests;
        this.numberOfRoom = numberOfRoom;
        this.roomName = roomName;
        this.numberOfNights = numberOfNights;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", day=" + day +
                ", price=" + price +
                ", numberOfGuests=" + numberOfGuests +
                ", numberOfRoom=" + numberOfRoom +
                ", roomName='" + roomName + '\'' +
                ", numberOfNights=" + numberOfNights +
                ", firstNameOfGuest='" + firstNameOfGuest + '\'' +
                ", lastNameOfGuest='" + lastNameOfGuest + '\'' +
                '}';
    }
}
