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

    public SignalRequest sendSignals() {
        SignalRequest signalRequest = new SignalRequest(tmpSignalList);
        tmpSignalList.clear();
        return signalRequest;
    }


}
