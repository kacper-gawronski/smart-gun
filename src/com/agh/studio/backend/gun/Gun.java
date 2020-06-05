package com.agh.studio.backend.gun;

import java.time.ZonedDateTime;

public class Gun {

    private Integer gunId;
    private Integer officerId;
    private Boolean isFired;
    private ZonedDateTime currentTime;

    public Gun(Integer gunId, Integer officerId) {
        this.gunId = gunId;
        this.officerId = officerId;
        this.isFired = false;
        this.currentTime = ZonedDateTime.now();
    }

    public Integer getGunId() {
        return gunId;
    }

    public void setGunId(Integer gunId) {
        this.gunId = gunId;
    }

    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

    public Boolean getFired() {
        return isFired;
    }

    public void setFired() {
        isFired = true;
    }

    public ZonedDateTime getCurrentTime() {
        return currentTime;
    }

    public GunRequest sendUpdate() {
        return new GunRequest(isFired, currentTime);
    }

    @Override
    public String toString() {
        return "GunId: " + getGunId() +
                "\nOfficerId: " + getOfficerId() +
                "\nisFired: " + getFired() +
                "\nTimestamp: " + getCurrentTime().toLocalDateTime();
    }
}
