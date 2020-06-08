package com.agh.studio;

import com.agh.studio.backend.gun.Gun;
import com.agh.studio.backend.navigation.Navigation;
import com.agh.studio.backend.smartwatch.Smartwatch;

import static com.agh.studio.backend.headquarter.HeadQuarter.headQuarterLocation;

public class Main {

    public static void main(String[] args) {

        Gun gun = new Gun(1, 1);
        Navigation navigation = new Navigation(1, headQuarterLocation);
        Smartwatch smartwatch = new Smartwatch(1, 1, gun, navigation);

        System.out.println(smartwatch.sendUpdate().toString());
        gun.setFired();
        System.out.println();

        System.out.println(smartwatch.sendUpdate().toString());
    }
}
