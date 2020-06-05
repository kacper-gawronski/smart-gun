package com.agh.studio.backend.gun;

import java.time.ZonedDateTime;

public class GunRequest {

    private Boolean isFired;
    private ZonedDateTime currentTimestamp;

    public GunRequest(Boolean isFired, ZonedDateTime currentTimestamp) {
        this.isFired = isFired;
        this.currentTimestamp = currentTimestamp;
    }

    public Boolean getFired() {
        return isFired;
    }

    public ZonedDateTime getCurrentTimestamp() {
        return currentTimestamp;
    }

    @Override
    public String toString() {
        return "Fired: " + isFired +
               "\nTime: " + currentTimestamp.toLocalDateTime();
    }
}
