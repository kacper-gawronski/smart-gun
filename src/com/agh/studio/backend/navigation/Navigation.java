package com.agh.studio.backend.navigation;

import java.util.Date;

public class Navigation {

    Location currentLocation;
    Location destinationLocation;

    // duration time in seconds from current location to destination location
    Integer duration;
    String durationText;

    // distance in meters from current location to destination location
    Integer distance;
    String distanceText;

    // możliwe że to pole nie będzie tutaj potrzebne (po analizie w razie potrzeby - usunąć)
    Boolean isGoingToIntervention;

    public Navigation(Location location) {
        this.isGoingToIntervention = false;
        this.currentLocation = location;
        this.destinationLocation = location;
        this.duration = 0;
        this.durationText = "";
        this.distance = 0;
        this.distanceText = "";
    }

    // GETTERS and SETTERS

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDurationText() {
        return durationText;
    }

    public void setDurationText(String durationText) {
        this.durationText = durationText;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getDistanceText() {
        return distanceText;
    }

    public void setDistanceText(String distanceText) {
        this.distanceText = distanceText;
    }

    public Boolean getGoingToIntervention() {
        return isGoingToIntervention;
    }

    public void setGoingToIntervention(Boolean goingToIntervention) {
        isGoingToIntervention = goingToIntervention;
    }
}
