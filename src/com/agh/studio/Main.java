package com.agh.studio;

import com.agh.studio.backend.central.MainAgent;
import com.agh.studio.backend.gun.Gun;
import com.agh.studio.backend.headquarter.HeadQuarter;
import com.agh.studio.backend.navigation.Navigation;
import com.agh.studio.backend.signalstorage.SignalDatabase;
import com.agh.studio.backend.smartwatch.Smartwatch;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        Gun gun1 = new Gun(1, 1);
        Gun gun2 = new Gun(2, 2);
        Navigation navigation1 = new Navigation(1, HeadQuarter.headQuarterLocation);
        Navigation navigation2 = new Navigation(2, HeadQuarter.headQuarterLocation);
        Smartwatch smartwatch1 = new Smartwatch(1, 1, gun1, navigation1);
        Smartwatch smartwatch2 = new Smartwatch(2, 2, gun2, navigation2);

        List<Smartwatch> smartwatchList = new ArrayList<>(List.of(smartwatch1, smartwatch2));
        SignalDatabase signalDatabase = new SignalDatabase();
        MainAgent MC = new MainAgent(signalDatabase, smartwatchList);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 5; j++) {
                if (i==1 && j==3) {
                    smartwatch1.getGun().setFired();
                }
                MC.collectSignals();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(signalDatabase.getTmpSignalList());
            System.out.println("\n\n");
            MC.receiveAndProcessSignals();
        }

        System.out.println(smartwatch1.sendUpdate().toString());
        gun1.setFired();
        System.out.println();
    }
}
