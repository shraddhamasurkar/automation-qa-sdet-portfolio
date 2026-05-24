package com.automation_amazon.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import com.automation_amazon.config.Config;

import java.time.Duration;

/**
 * WaitHelper for handling explicit waits
 * Provides methods for waiting on various element conditions
 */
public class WaitHelper {
    
    private WebDriver driver;
    private WebDriverWait wait;
    
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.EXPLICIT_WAIT));
    }
    
    /**
     * Wait for element to be visible
     */
    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Wait for element to be clickable
     */
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    /**
     * Wait for element to be present
     */
    public WebElement waitForElementToBePresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    /**
     * Wait for text to be present in element
     */
    public boolean waitForTextInElement(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
    
    /**
     * Wait for URL to contain specific text
     */
    public boolean waitForUrlContains(String urlFraction) {
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }
}
