package com.agh.studio.backend.smartwatch;

import java.time.ZonedDateTime;

public class SmartwatchReport {

    private ZonedDateTime reportTime;
    private Integer smartwatchId;
    private Integer officerId;
    private Integer gunId;
    private Boolean isGunFired;

    public SmartwatchReport(ZonedDateTime reportTime, Integer smartwatchId,
                            Integer officerId, Integer gunId, Boolean isGunFired) {
        this.reportTime = reportTime;
        this.smartwatchId = smartwatchId;
        this.officerId = officerId;
        this.gunId = gunId;
        this.isGunFired = isGunFired;
    }

    public ZonedDateTime getReportTime() {
        return reportTime;
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

    public Boolean getGunFired() {
        return isGunFired;
    }

    @Override
    public String toString() {
        return "SmartwatchId: " + getSmartwatchId() +
                "\nOfficerId: " + getOfficerId() +
                "\nGunId: " + getGunId() +
                "\nReportTime: " + getReportTime().toLocalDateTime() +
                "\nisGunFired: " + getGunFired();
    }

}
