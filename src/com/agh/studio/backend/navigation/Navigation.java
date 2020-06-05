package com.agh.studio.backend.navigation;

import java.time.ZonedDateTime;

public class Navigation {

    private Integer vehicleId;

    private Location currentLocation;
    private Location destinationLocation;

    // duration time in seconds from current location to destination location
    private Integer duration;
    private String durationText;

    // distance in meters from current location to destination location
    private Integer distance;
    private String distanceText;

    public Navigation(Integer vehicleId, Location location) {
        this.vehicleId = vehicleId;
        this.currentLocation = location;
        this.destinationLocation = null;
        this.duration = 0;
        this.durationText = "";
        this.distance = 0;
        this.distanceText = "";
    }

    public NavigationRequest sendUpdate() {
        return new NavigationRequest(currentLocation);
    }

    // GETTERS and SETTERS

    public Integer getVehicleId() {
        return vehicleId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDurationText() {
        return durationText;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getDistanceText() {
        return distanceText;
    }
}
