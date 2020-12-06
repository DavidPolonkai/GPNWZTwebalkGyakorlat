package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;
import java.util.List;

public class Wing {
    private String description;
    private Floor floor;
    private WingType wingType;
    private List<Room> rooms;

    public Wing(String description, Floor floor, WingType wingType) {
        this.description = description;
        this.floor = floor;
        this.wingType = wingType;
        this.rooms = new ArrayList<>();
    }

    public Wing() {
        this.rooms = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public WingType getWingType() {
        return wingType;
    }

    public void setWingType(WingType wingType) {
        this.wingType = wingType;
    }

}
