package com.agh.studio.backend.smartwatch;

import com.agh.studio.backend.navigation.Location;

import java.time.ZonedDateTime;

public class SmartwatchReport {

    private ZonedDateTime reportTime;
    private Smartwatch smartwatch;
    private Integer smartwatchId;
    private Integer officerId;
    private Integer gunId;
    private Integer vehicleId;
    private Boolean isGunFired;
    private Location location;
    private PatrolStatus status;

    public SmartwatchReport(ZonedDateTime reportTime, Smartwatch smartwatch, Integer smartwatchId, Integer officerId,
                            Integer gunId, Integer vehicleId, Boolean isGunFired, Location location, PatrolStatus status) {
        this.reportTime = reportTime;
        this.smartwatch = smartwatch;
        this.smartwatchId = smartwatchId;
        this.officerId = officerId;
        this.gunId = gunId;
        this.vehicleId = vehicleId;
        this.isGunFired = isGunFired;
        this.location = location;
        this.status = status;
    }

    public ZonedDateTime getReportTime() {
        return reportTime;
    }

    public Smartwatch getSmartwatch() {
        return smartwatch;
    }

    public Integer getSmartwatchId() {
        return smartwatchId;
    }

    public Integer getOfficerId() {
        return officerId;
    }

    public Integer getGunId() {
        return gunId;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public Boolean getGunFired() {
        return isGunFired;
    }

    public Location getLocation() {
        return location;
    }

    public PatrolStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "SmartwatchId: " + getSmartwatchId() +
                "\nOfficerId: " + getOfficerId() +
                "\nGunId: " + getGunId() +
                "\nVehicleId: " + getVehicleId() +
                "\nReportTime: " + getReportTime().toLocalDateTime() +
                "\nisGunFired: " + getGunFired() +
                "\nLocation: " + getLocation() +
                "\nPatrolStatus: " + getStatus();
    }

}
