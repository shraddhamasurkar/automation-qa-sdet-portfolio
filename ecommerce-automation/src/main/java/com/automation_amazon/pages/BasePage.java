package com.automation_amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.automation_amazon.utils.WaitHelper;

/**
 * BasePage class - Parent class for all page objects
 * Contains common methods and utilities for all pages
 */
public class BasePage {
    
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }
    
    /**
     * Click on element
     */
    protected void click(By locator) {
        waitHelper.waitForElementToBeClickable(locator).click();
    }
    
    /**
     * Send text to input field
     */
    protected void sendKeys(By locator, String text) {
        WebElement element = waitHelper.waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }
    
    /**
     * Get text from element
     */
    protected String getText(By locator) {
        return waitHelper.waitForElementToBeVisible(locator).getText();
    }
    
    /**
     * Check if element is displayed
     */
    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Get page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
    
    /**
     * Navigate to URL
     */
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }
}
