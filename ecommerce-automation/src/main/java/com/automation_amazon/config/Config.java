package com.automation_amazon.config;

/**
 * Configuration class for test environment settings
 */
public class Config {
    
    public static final String BASE_URL = "https://www.amazon.in";
    public static final long IMPLICIT_WAIT = 10;
    public static final long EXPLICIT_WAIT = 15;
    public static final boolean HEADLESS_MODE = false;
    
    // Browser configuration
    public static final String BROWSER = System.getProperty("browser", "chrome");
    
    // Screenshot and Report paths
    public static final String SCREENSHOT_PATH = "screenshots/";
    public static final String REPORT_PATH = "test-output/";
    
    // Test data
    public static final String VALID_EMAIL = "test.automation.qa@gmail.com";
    public static final String VALID_PASSWORD = "TestPassword@123";
    public static final String SEARCH_QUERY = "laptop";
}
