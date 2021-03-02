package com.example.myreservationapp.model.data;

public class Room {
    private int room_id;
    private String roomName;
    private int numberOfRoom;
    private double price;

    public Room(int room_id, String roomName, int numberOfRoom, double price) {
        this.room_id = room_id;
        this.roomName = roomName;
        this.numberOfRoom = numberOfRoom;
        this.price = price;
    }

    public int getRoom_id() {
        return room_id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
