package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
	private static ExtentReports report;

    public static ExtentReports getReportInstance() {
        if (report == null) { // Singleton pattern
            String reportName = "NykaaReport_" + DateUtils.getTimeStamp() + ".html";

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
                    System.getProperty("user.dir") + "\\test-output\\" + reportName);

            report = new ExtentReports();
            report.attachReporter(htmlReporter);

            report.setSystemInfo("OS", "Windows 11");
            report.setSystemInfo("Environment", "QA");
            report.setSystemInfo("Tester", "Vinamra");

            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("Nykaa Test Report");
            //htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        }
        return report;
    }
}


