package com.meiit.webalk.reservation.domain;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private Hotel hotel;
    private List<Wing> wings;

    public Floor(int floorNumber, Hotel hotel) {
        this.floorNumber = floorNumber;
        this.hotel = hotel;
        this.wings = new ArrayList<>();
    }

    public Floor() {

    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Wing> getWings() {
        return wings;
    }

    public void setWings(List<Wing> wings) {
        this.wings = wings;
    }

}
