package com.agh.studio.backend.gun;

public class Gun {

    private Integer gunId;
    private Integer officerId;
    private Boolean isFired;

    public Gun(Integer gunId, Integer officerId) {
        this.gunId = gunId;
        this.officerId = officerId;
        this.isFired = false;
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

    public void setFired(Boolean fired) {
        isFired = fired;
    }

    public void setFired() {
        isFired = true;
    }

    public GunRequest sendUpdate() {
        return new GunRequest(isFired);
    }

    @Override
    public String toString() {
        return "GunId: " + getGunId() +
                "\nOfficerId: " + getOfficerId() +
                "\nisFired: " + getFired();
    }
}
