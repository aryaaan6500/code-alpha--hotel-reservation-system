package com.hotelreservation.model;

public enum RoomType {
    SINGLE("Single Room"),
    DOUBLE("Double Room"),
    SUITE("Suite"),
    DELUXE("Deluxe"),
    PENTHOUSE("Penthouse");
    
    private final String displayName;
    
    RoomType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
