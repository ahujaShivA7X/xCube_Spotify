package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("test-output/extent.html");
        }
        return extent;
    }

    public static void createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Spotify Appium Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Spotify Mobile Automation Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    public static ExtentTest createTest(String testName) {
        test = extent.createTest(testName);
        return test;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flush() {
        extent.flush();
    }
}
