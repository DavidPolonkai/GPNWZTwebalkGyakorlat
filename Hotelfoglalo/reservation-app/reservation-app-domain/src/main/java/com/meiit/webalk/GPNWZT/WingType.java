package com.meiit.webalk.GPNWZT;

public enum WingType {
    NORTH("North"), EAST("East"), WEST("West"), SOUTH("South");

    private String type;

    private WingType(String type) {
        this.type = type;
    }

    String getType() {
        return type;
    }
}
