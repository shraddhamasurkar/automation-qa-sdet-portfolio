package com.automation_amazon.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import com.automation_amazon.utils.DriverFactory;
import com.automation_amazon.utils.ExtentReportManager;
import com.automation_amazon.config.Config;

/**
 * BaseTest - Parent class for all test classes
 * Manages setup and teardown of WebDriver and Extent Reports
 */
public class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Initialize WebDriver
        driver = DriverFactory.initializeDriver(Config.BROWSER);
        
        // Navigate to base URL
        driver.navigate().to(Config.BASE_URL);
        
        // Implicit wait
        driver.manage().timeouts()
                .implicitlyWait(java.time.Duration.ofSeconds(Config.IMPLICIT_WAIT));
    }
    
    @AfterMethod
    public void tearDown() {
        // Close WebDriver
        DriverFactory.quitDriver();
    }
}
