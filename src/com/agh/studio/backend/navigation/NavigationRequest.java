package com.agh.studio.backend.navigation;

import java.time.ZonedDateTime;

public class NavigationRequest {

    private Location location;

    public NavigationRequest(Location location, ZonedDateTime currentTimestamp) {
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
