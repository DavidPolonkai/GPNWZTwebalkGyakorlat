package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String address;
    private int stars;
    private List<Floor> floors;

    public Hotel(String name, String address, int stars) {
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.floors = new ArrayList<>();
    }

    public Hotel() {
        this.floors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
