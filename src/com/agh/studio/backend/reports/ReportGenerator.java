package com.agh.studio.backend.reports;

import com.agh.studio.backend.smartwatch.SmartwatchReport;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

public class ReportGenerator {

    private static final String[] headerList = {"reportTime", "smartwatchId", "officerId", "gunId",
                                                "vehicleId", "isGunFired", "patrolLatitude", "patrolLongitude",
                                                "patrolStatus"};

    public void writeSmartwatchReportsToCsvFile(List<SmartwatchReport> swReports, ZonedDateTime dateTime) {
        String filepath = "/smart-gun/reports/" + dateTime.toString() + ".csv";

        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filepath));
            writer.writeNext(headerList);

            for (SmartwatchReport swReport : swReports) {
                String[] report = formatSingleReportToCsv(swReport);
                writer.writeNext(report);
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[] formatSingleReportToCsv(SmartwatchReport swReport) {

        return new String[]{ String.valueOf(swReport.getReportTime()),
                            String.valueOf(swReport.getSmartwatchId()),
                            String.valueOf(swReport.getOfficerId()),
                            String.valueOf(swReport.getGunId()),
                            String.valueOf(swReport.getVehicleId()),
                            String.valueOf(swReport.getGunFired()),
                            String.valueOf(swReport.getLocation().getLatitude()),
                            String.valueOf(swReport.getLocation().getLongitude()),
                            String.valueOf(swReport.getStatus())
        };

    }

}
