package com.agh.studio.backend.signalstorage;

import com.agh.studio.backend.smartwatch.Smartwatch;
import com.agh.studio.backend.smartwatch.SmartwatchReport;

import java.util.ArrayList;
import java.util.List;

public class SignalDatabase {

    private List<SmartwatchReport> signalList; // OUR DATABASE
    private List<SmartwatchReport> tmpSignalList;

    public SignalDatabase() {
        signalList = new ArrayList<>();
        tmpSignalList = new ArrayList<>();
    }

    public void receiveDataFromSmartwatches(List<Smartwatch> smartwatchList) {

        SmartwatchReport smartwatchReport;

        for (Smartwatch smartwatch : smartwatchList) {
            smartwatchReport = smartwatch.sendUpdate();
            signalList.add(smartwatchReport);
            tmpSignalList.add(smartwatchReport);
        }

    }

    public List<SmartwatchReport> sendSignals() {

        List<SmartwatchReport> smartwatchReportList = tmpSignalList;
        tmpSignalList.clear();

        return smartwatchReportList;
    }

    public List<SmartwatchReport> getSignalList() {
        return signalList;
    }

    public List<SmartwatchReport> getTmpSignalList() {
        return tmpSignalList;
    }
}
