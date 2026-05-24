package com.automation_amazon.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.automation_amazon.config.Config;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ExtentReportManager for generating HTML test reports
 */
public class ExtentReportManager {
    
    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    /**
     * Initialize Extent Reports
     */
    public static void initializeExtentReport() {
        String reportPath = Config.REPORT_PATH + "Report_" + 
                           LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + 
                           ".html";
        
        new File(Config.REPORT_PATH).mkdirs();
        
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Amazon Automation Test Report");
        sparkReporter.config().setReportName("E-Commerce Test Execution Report");
        
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Base URL", Config.BASE_URL);
    }
    
    /**
     * Create test entry
     */
    public static void createTest(String testName, String description) {
        ExtentTest extentTest = extentReports.createTest(testName, description);
        test.set(extentTest);
    }
    
    /**
     * Log test step
     */
    public static void logTestStep(String message) {
        test.get().info(message);
    }
    
    /**
     * Log test pass
     */
    public static void logTestPass(String message) {
        test.get().pass(message);
    }
    
    /**
     * Log test fail
     */
    public static void logTestFail(String message) {
        test.get().fail(message);
    }
    
    /**
     * Flush reports
     */
    public static void flushReport() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}
