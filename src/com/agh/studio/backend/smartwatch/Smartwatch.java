package com.agh.studio.backend.smartwatch;

import com.agh.studio.backend.gun.Gun;
import com.agh.studio.backend.gun.GunRequest;
import com.agh.studio.backend.navigation.Navigation;

public class Smartwatch {

    private Integer smartwatchId;
    private Integer officerId;
    private PatrolStatus status;

    private Gun gun;
    private Navigation navigation;

    public Smartwatch(Integer smartwatchId, Integer officerId, Gun gun, Navigation navigation) {
        this.smartwatchId = smartwatchId;
        this.officerId = officerId;
        this.gun = gun;
        this.navigation = navigation;
        this.status = PatrolStatus.OBSERVER;
    }

    public Integer getSmartwatchId() {
        return smartwatchId;
    }

    public Integer getOfficerId() {
        return officerId;
    }

    public PatrolStatus getStatus() {
        return status;
    }

    public Gun getGun() {
        return gun;
    }

    public Navigation getNavigation() {
        return navigation;
    }

    public SmartwatchReport sendUpdate() {

        GunRequest gunRequest = getGun().sendUpdate();

        return new SmartwatchReport(
                gunRequest.getCurrentTimestamp(),
                getSmartwatchId(),
                getOfficerId(),
                getGun().getGunId(),
                gunRequest.getFired()
        );

    }

    @Override
    public String toString() {
        return "SmartwatchId: " + getSmartwatchId() +
               "\nOfficerId: " + getOfficerId() +
               "\nPatrol Status: " + getStatus();
    }
}
