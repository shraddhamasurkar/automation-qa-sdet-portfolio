package com.automation_amazon.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.automation_amazon.config.Config;

/**
 * DriverFactory for WebDriver initialization
 * Manages browser instantiation for Chrome and Firefox
 */
public class DriverFactory {
    
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    /**
     * Initialize WebDriver based on browser type
     */
    public static WebDriver initializeDriver(String browser) {
        WebDriver webDriver = null;
        
        switch (browser.toLowerCase()) {
            case "chrome":
                webDriver = initializeChromeDriver();
                break;
            case "firefox":
                webDriver = initializeFirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        
        webDriver.manage().window().maximize();
        driver.set(webDriver);
        return webDriver;
    }
    
    /**
     * Initialize Chrome WebDriver
     */
    private static WebDriver initializeChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        
        if (Config.HEADLESS_MODE) {
            options.addArguments("--headless");
        }
        
        return new ChromeDriver(options);
    }
    
    /**
     * Initialize Firefox WebDriver
     */
    private static WebDriver initializeFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        
        if (Config.HEADLESS_MODE) {
            options.addArguments("--headless");
        }
        
        return new FirefoxDriver(options);
    }
    
    /**
     * Get current WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }
    
    /**
     * Close and quit WebDriver
     */
    public static void quitDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}
