package com.meiit.webalk.reservation.domain;

public class Room {
    private int number;
    private int beds;
    private boolean balcony;
    private int price;
    private Wing wing;

    public Room(int number, int beds, boolean balcony, int price, Wing wing) {
        this.number = number;
        this.beds = beds;
        this.balcony = balcony;
        this.price = price;
        this.wing = wing;
    }

    public Room() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

}
