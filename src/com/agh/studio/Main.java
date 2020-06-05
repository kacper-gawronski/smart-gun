package com.agh.studio;

import com.agh.studio.backend.gun.Gun;
import com.agh.studio.backend.navigation.Navigation;
import com.agh.studio.backend.smartwatch.Smartwatch;

public class Main {

    public static void main(String[] args) {

        Gun gun = new Gun(1, 1);
        Smartwatch smartwatch = new Smartwatch(1, 1, gun, new Navigation());

        System.out.println(smartwatch.sendUpdate().toString());
        gun.setFired();
        System.out.println();

        System.out.println(smartwatch.sendUpdate().toString());

    }
}
