package com.agh.studio.backend.headquarter;

import com.agh.studio.backend.navigation.Location;
import com.agh.studio.backend.smartwatch.PatrolStatus;
import com.agh.studio.backend.smartwatch.Smartwatch;
import com.agh.studio.backend.smartwatch.SmartwatchReport;

public class HeadQuarter {

    // wstępnie zakładam że patrole wychodzące z kwatery będą dostawały taką
    // początkową lokalizacje (np. komenda wojewódzka Policji w Krakowie)
    public static final Location headQuarterLocation = new Location(50.067258, 19.979021);

    public static final int updateMilliseconds = 100;

    // basic version - computing distance in straight line
    public double calculateDistanceBetween(Location objective, Location support) {

        double objectiveLong = Math.toRadians(objective.getLongitude());
        double objectiveLat = Math.toRadians(objective.getLatitude());

        double supportLong = Math.toRadians(support.getLongitude());
        double supportLat = Math.toRadians(support.getLatitude());

        double diffLong = supportLong - objectiveLong;
        double diffLat = supportLat - objectiveLat;

        double a = Math.pow(Math.sin(diffLat / 2), 2)
                + Math.cos(objectiveLat) * Math.cos(supportLat)
                + Math.pow(Math.sin(diffLong / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double earthRadius = 6371;

        return (c * earthRadius);
    }

    public int howManyHelp(SmartwatchReport smartwatchReport) {

        int helpers = 0;

        if (smartwatchReport.getStatus() == PatrolStatus.FIRE_INTERVENTION) {
            helpers = 2;
        } else if (smartwatchReport.getStatus() == PatrolStatus.PURSUIT) {
            helpers = 3;
        }

        if (!isDay(smartwatchReport)) {
            return ++helpers;
        }

        return helpers;
    }

    private Boolean isDay(SmartwatchReport smartwatchReport) {
        int hour = smartwatchReport.getReportTime().getHour();

        return (hour >= 6 && hour <= 22);
    }

}
