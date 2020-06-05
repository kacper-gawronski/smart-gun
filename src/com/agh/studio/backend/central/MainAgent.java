package com.agh.studio.backend.central;

import com.agh.studio.backend.navigation.Location;
import com.agh.studio.backend.signalstorage.SignalDatabase;
import com.agh.studio.backend.smartwatch.PatrolStatus;
import com.agh.studio.backend.smartwatch.Smartwatch;
import com.agh.studio.backend.smartwatch.SmartwatchReport;

import java.util.List;

public class MainAgent {

    private SignalDatabase signalDatabase;

    private List<Smartwatch> smartwatchList;

    public MainAgent(SignalDatabase signalDatabase, List<Smartwatch> smartwatchList) {
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
                chooseAndSendPatrolsToFireIntervention(smartwatchReport.getSmartwatch());
            else if (smartwatchReport.getStatus() == PatrolStatus.ROUTINE_INTERVENTION)
                chooseAndSendPatrolsToRoutineIntervention(smartwatchReport.getSmartwatch());
            else if (smartwatchReport.getStatus() == PatrolStatus.PURSUIT)
                chooseAndSendPatrolsToPursuit(smartwatchReport.getSmartwatch());
        }
    }

    public void chooseAndSendPatrolsToFireIntervention(Smartwatch smartwatchInNeedOfHelp) {
        // zaimplementować
    }

    public void chooseAndSendPatrolsToRoutineIntervention(Smartwatch smartwatchInNeedOfHelp) {
        // zaimplementować
    }

    public void chooseAndSendPatrolsToPursuit(Smartwatch smartwatchInNeedOfHelp) {
        // zaimplementować
    }

    public void sendParametersToSmartwatch(Smartwatch smartwatch, PatrolStatus patrolStatus, Location location) {
        smartwatch.updateParameters(patrolStatus, location);
        // inne parametry, które będziemy chcieli przekazać
    }

    public void sendGoingToInterventionToSmartwatch(Smartwatch smartwatch, Location interventionLocation) {
        smartwatch.updateParameters(PatrolStatus.GOING_TO_INTERVENTION, interventionLocation);
    }

    public void sendEndOfInterventionToSmartwatch(Smartwatch smartwatch) {
        smartwatch.updateParameters(PatrolStatus.OBSERVER, null);
        smartwatch.getGun().setFired(false);
        // inne parametry, które będziemy chcieli przekazać
    }
}
