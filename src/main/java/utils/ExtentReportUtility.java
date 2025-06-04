package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

    public static ExtentReports config() {

        String path = System.getProperty("user.dir") + "//reports//index.html";

        ExtentSparkReporter spr = new ExtentSparkReporter(path);

        spr.config().setReportName("Automation Report");
        spr.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        spr.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();

        extent.attachReporter(spr);

        extent.setSystemInfo("Tester", "Narendra Vyas");

        return extent;
    }
}
