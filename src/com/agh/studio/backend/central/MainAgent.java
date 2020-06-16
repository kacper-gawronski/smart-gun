package com.agh.studio.backend.central;

import com.agh.studio.backend.headquarter.HeadQuarter;
import com.agh.studio.backend.navigation.Location;
import com.agh.studio.backend.signalstorage.SignalDatabase;
import com.agh.studio.backend.smartwatch.PatrolStatus;
import com.agh.studio.backend.smartwatch.Smartwatch;
import com.agh.studio.backend.smartwatch.SmartwatchReport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainAgent {

    private HeadQuarter headQuarter;

    private SignalDatabase signalDatabase;

    private List<Smartwatch> smartwatchList;

    public MainAgent(HeadQuarter headQuarter, SignalDatabase signalDatabase, List<Smartwatch> smartwatchList) {
        this.headQuarter = headQuarter;
        this.signalDatabase = signalDatabase;
        this.smartwatchList = smartwatchList;
    }

    // wywołanie z pozoimu Main, częstość zależna od parametrów w HQ
    public void collectSignals() {
        signalDatabase.receiveDataFromSmartwatches(smartwatchList);
    }

    public void receiveAndProcessSignals() {
        List<SmartwatchReport> smartwatchReportList = signalDatabase.sendSignals();

        for (SmartwatchReport smartwatchReport : smartwatchReportList) {
            if (smartwatchReport.getStatus() == PatrolStatus.FIRE_INTERVENTION)
                sendPatrolsToFireIntervention(smartwatchReport.getSmartwatch());
            else if (smartwatchReport.getStatus() == PatrolStatus.ROUTINE_INTERVENTION)
                sendPatrolsToRoutineIntervention(smartwatchReport.getSmartwatch());
            else if (smartwatchReport.getStatus() == PatrolStatus.PURSUIT)
                sendPatrolsToPursuit(smartwatchReport.getSmartwatch());
        }
    }

    public void sendPatrolsToFireIntervention(Smartwatch smartwatchInNeedOfHelp) {

        Location destination = smartwatchInNeedOfHelp.getNavigation().getCurrentLocation();

        Set<Smartwatch> patrolsToBeSent = chooseTheClosestPatrols(destination, 3).keySet();

        for (Smartwatch smartwatch : patrolsToBeSent) {
            sendGoingToInterventionToSmartwatch(smartwatch, destination);
        }

    }

    public void sendPatrolsToRoutineIntervention(Smartwatch smartwatchInNeedOfHelp) {

        Location destination = smartwatchInNeedOfHelp.getNavigation().getCurrentLocation();

        Set<Smartwatch> patrolsToBeSent = chooseTheClosestPatrols(destination, 1).keySet();

        for (Smartwatch smartwatch : patrolsToBeSent) {
            sendGoingToInterventionToSmartwatch(smartwatch, destination);
        }

    }

    public void sendPatrolsToPursuit(Smartwatch smartwatchInNeedOfHelp) {

        Location destination = smartwatchInNeedOfHelp.getNavigation().getCurrentLocation();

        Set<Smartwatch> patrolsToBeSent = chooseTheClosestPatrols(destination, 4).keySet();

        for (Smartwatch smartwatch : patrolsToBeSent) {
            sendGoingToInterventionToSmartwatch(smartwatch, destination);
        }

    }

    public void sendParametersToSmartwatch(Smartwatch smartwatch, PatrolStatus patrolStatus, Location destinationLocation) {
        smartwatch.updateParameters(patrolStatus, destinationLocation);
        // inne parametry, które będziemy chcieli przekazać
    }

    // ta funkcja może być wgl nie potrzebna i wystarczy ta wyżej z odpowiednimi parametrami
    public void sendGoingToInterventionToSmartwatch(Smartwatch smartwatch, Location interventionLocation) {
        smartwatch.updateParameters(PatrolStatus.GOING_TO_INTERVENTION, interventionLocation);
    }

    // ta fukncja może być wgl nie potrzebna, ponieważ po interwencji patrol sam powinien zmienić status na OBSERVER
    // lub funkcja może zostać ale wtedy Patrol musiałby przesłać jakieś info o zakończeniu interwencji więc najlepiej zostawić zmianę statusu w samym Patrolu(SW)
    public void sendEndOfInterventionToSmartwatch(Smartwatch smartwatch) {
        smartwatch.updateParameters(PatrolStatus.OBSERVER, null);
        smartwatch.getGun().setFired(false);
        // inne parametry, które będziemy chcieli przekazać
    }


    private Map<Smartwatch, Double> chooseTheClosestPatrols(Location patrolInNeed, int numberOfHelpers) {

        Map<Smartwatch, Double> patrolHelpers = new HashMap<>();

        for (Smartwatch smartwatch : smartwatchList) {
            double distance = headQuarter.calculateDistanceBetween(patrolInNeed, smartwatch.getNavigation().getCurrentLocation());
            patrolHelpers.put(smartwatch, distance);
        }

        return patrolHelpers
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(numberOfHelpers)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, HashMap::new));
    }

}
