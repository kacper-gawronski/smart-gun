package com.agh.studio;

import com.agh.studio.backend.central.MainAgent;
import com.agh.studio.backend.gun.Gun;
import com.agh.studio.backend.headquarter.HeadQuarter;
import com.agh.studio.backend.navigation.Location;
import com.agh.studio.backend.navigation.Navigation;
import com.agh.studio.backend.signalstorage.SignalDatabase;
import com.agh.studio.backend.smartwatch.PatrolStatus;
import com.agh.studio.backend.smartwatch.Smartwatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    private static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static double generateRandomDouble(int min, int max) {
        Random random = new Random();
        return random.nextDouble() * (max - min) + min;
    }

    public static void main(String[] args) {

        Gun gun1 = new Gun(1, 1);
        Gun gun2 = new Gun(2, 2);
        Gun gun3 = new Gun(3, 3);
        Gun gun4 = new Gun(4, 4);
        Gun gun5 = new Gun(5, 5);
        Gun gun6 = new Gun(6, 6);
        Gun gun7 = new Gun(7, 7);
        Gun gun8 = new Gun(8, 8);

        Navigation navigation1 = new Navigation(1, HeadQuarter.headQuarterLocation);
        Navigation navigation2 = new Navigation(2, new Location(50.070440, 19.944895));
        Navigation navigation3 = new Navigation(3, new Location(50.079207, 19.921535));
        Navigation navigation4 = new Navigation(4, new Location(50.040718, 19.955929));
        Navigation navigation5 = new Navigation(5, new Location(50.065311, 19.995814));
        Navigation navigation6 = new Navigation(6, new Location(50.089713, 19.979050));
        Navigation navigation7 = new Navigation(7, new Location(50.078425, 19.949091));
        Navigation navigation8 = new Navigation(8, new Location(50.087983, 20.014342));

        Smartwatch smartwatch1 = new Smartwatch(1, 1, gun1, navigation1);
        Smartwatch smartwatch2 = new Smartwatch(2, 2, gun2, navigation2);
        Smartwatch smartwatch3 = new Smartwatch(3, 3, gun3, navigation3);
        Smartwatch smartwatch4 = new Smartwatch(4, 4, gun4, navigation4);
        Smartwatch smartwatch5 = new Smartwatch(5, 5, gun5, navigation5);
        Smartwatch smartwatch6 = new Smartwatch(6, 6, gun6, navigation6);
        Smartwatch smartwatch7 = new Smartwatch(7, 7, gun7, navigation7);
        Smartwatch smartwatch8 = new Smartwatch(8, 8, gun8, navigation8);

        List<Smartwatch> smartwatchList = new ArrayList<>(List.of(
                smartwatch1,
                smartwatch2,
                smartwatch3,
                smartwatch4,
                smartwatch5,
                smartwatch6,
                smartwatch7,
                smartwatch8
        ));

        SignalDatabase signalDatabase = new SignalDatabase();
        HeadQuarter headQuarter = new HeadQuarter();
        MainAgent MC = new MainAgent(headQuarter, signalDatabase, smartwatchList);


        for (int i = 0; i < 5; i++) {

            if (i == 2) {
                smartwatch8.getGun().setFired();
            }

            MC.collectSignals();

            System.out.println(signalDatabase.getTmpSignalList());
            System.out.println("\n----------------------------------------------------------------\n");

            MC.receiveAndProcessSignals();

            try {
                Thread.sleep(HeadQuarter.updateMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Smartwatch sm : smartwatchList) {
                if (sm.getStatus() == PatrolStatus.OBSERVER) {
                    double latitude = sm.getNavigation().getCurrentLocation().getLatitude();
                    double longitude = sm.getNavigation().getCurrentLocation().getLongitude();
                    sm.getNavigation().updateCurrentLocation(
                            latitude + generateRandomDouble(-10, 10) * 0.001,
                            longitude + generateRandomDouble(-10, 10) * 0.001
                    );
                }
            }

        }


    }

}
