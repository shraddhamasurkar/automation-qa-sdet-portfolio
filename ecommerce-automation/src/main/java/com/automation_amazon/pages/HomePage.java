package com.automation_amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * HomePage - Page Object for Amazon Home Page
 * Demonstrates dynamic locators for search functionality
 */
public class HomePage extends BasePage {
    
    // Dynamic locators
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By accountLink = By.xpath("//a[@id='nav-link-accountList']");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Search for product - demon 
     */
    public void searchForProduct(String product) {
        sendKeys(searchBox, product);
        click(searchButton);
    }
    
    /**
     * Click on account link
     */
    public void clickAccountLink() {
        click(accountLink);
    }
    
    /**
     * Verify home page loaded
     */
    public boolean isHomePageLoaded() {
        return isElementDisplayed(searchBox);
    }
}
