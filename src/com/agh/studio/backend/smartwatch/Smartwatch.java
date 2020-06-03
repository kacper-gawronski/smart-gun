package com.agh.studio.backend.smartwatch;

import com.agh.studio.backend.navigation.Location;
import com.agh.studio.backend.navigation.Navigation;

public class Smartwatch {

    // Trzeba zaimplementować pola odpowiedzialne za rodzaj interwencji oraz czy paatrol dojeżdża czy jest na miejscu czy po prostu patroluje
    // w przypadku wezwania do interwencji od mastera następuje wywołanie setNavigationParameters()
    // w przypadku anulowania wezwania do interwencji następuje wywołanie cancellationOfIntervention()

    Navigation navigation;
    Location location;

    void updateLocation() {
        this.location = navigation.getCurrentLocation();
    }

    void setNavigationParameters(Location destination, Integer duration, Integer distance, String durationText, String distanceText) {
        navigation.setGoingToIntervention(true);
        navigation.setDestinationLocation(destination);
        navigation.setDuration(duration);
        navigation.setDistance(distance);
        navigation.setDurationText(durationText);
        navigation.setDistanceText(distanceText);
    }

    void cancellationOfIntervention() {
        navigation.setGoingToIntervention(false);
        navigation.setDestinationLocation(navigation.getCurrentLocation());
        navigation.setDuration(0);
        navigation.setDistance(0);
        navigation.setDurationText("");
        navigation.setDistanceText("");
    }


}
