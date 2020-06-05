package com.agh.studio.backend.central;

import com.agh.studio.backend.emergency.AmbulanceCenter;
import com.agh.studio.backend.signalstorage.SignalDatabase;
import com.agh.studio.backend.signalstorage.SignalRequest;
import com.agh.studio.backend.smartwatch.PatrolStatus;
import com.agh.studio.backend.smartwatch.Smartwatch;
import com.agh.studio.backend.smartwatch.SmartwatchReport;

import java.util.List;
import java.util.Map;

public class MainAgent {

    private SignalDatabase signalDatabase;
    private AmbulanceCenter ambulanceCenter;

    private List<Smartwatch> smartwatchList;
    private Map<Integer, PatrolStatus> statusMap;

    public MainAgent(SignalDatabase signalDatabase, AmbulanceCenter ambulanceCenter, List<Smartwatch> smartwatchList) {
        this.signalDatabase = signalDatabase;
        this.ambulanceCenter = ambulanceCenter;
        this.smartwatchList = smartwatchList;
        for (Smartwatch smartwatch : smartwatchList) {
            statusMap.put(smartwatch.getSmartwatchId(), smartwatch.getStatus());
        }
    }

    public void receiveSignals() {
        SignalRequest signalRequest = signalDatabase.sendSignals();
        for (SmartwatchReport smartwatchReport : signalRequest.getSmartwatchReportList()) {
            statusMap.put(smartwatchReport.getSmartwatchId(), smartwatchReport.getStatus());
        }
    }
}
