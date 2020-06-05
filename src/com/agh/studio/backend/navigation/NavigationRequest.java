package com.agh.studio.backend.navigation;

public class NavigationRequest {

    private Location location;

    public NavigationRequest(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Location: " + getLocation();
    }
}
