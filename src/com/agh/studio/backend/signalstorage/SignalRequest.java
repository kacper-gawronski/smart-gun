package com.agh.studio.backend.signalstorage;

import com.agh.studio.backend.smartwatch.SmartwatchReport;

import java.util.List;

public class SignalRequest {

    private List<SmartwatchReport> smartwatchReportList;

    public SignalRequest(List<SmartwatchReport> smartwatchReportList) {
        this.smartwatchReportList = smartwatchReportList;
    }

    public List<SmartwatchReport> getSmartwatchReportList() {
        return smartwatchReportList;
    }

    @Override
    public String toString() {
        return "SignalRequest{\n" +
                smartwatchReportList +
                "\n}";
    }
}
