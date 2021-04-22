package com.switchfully.spaceshark.model.parkingLot;

public enum Category {

    UNDERGROUND_BUILDING("underground building"),
    ABOVE_GROUND_BUILDING("above ground building");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
