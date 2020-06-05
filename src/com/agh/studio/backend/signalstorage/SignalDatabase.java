package com.agh.studio.backend.signalstorage;

import com.agh.studio.backend.smartwatch.SmartwatchReport;

import java.util.ArrayList;
import java.util.List;

public class SignalDatabase {

    private List<SmartwatchReport> signalList;
    private List<SmartwatchReport> tmpSignalList;

    public SignalDatabase() {
        signalList = new ArrayList<>();
        tmpSignalList = new ArrayList<>();
    }

    public List<SmartwatchReport> sendSignals() {
        List<SmartwatchReport> smartwatchReportList = tmpSignalList;
        tmpSignalList.clear();
        return smartwatchReportList;
    }


}
