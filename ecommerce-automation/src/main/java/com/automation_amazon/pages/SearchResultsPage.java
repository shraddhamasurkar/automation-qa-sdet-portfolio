package com.automation_amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * SearchResultsPage - Page Object for Search Results Page
 * Demonstrates dynamic locators and list handling
 */
public class SearchResultsPage extends BasePage {
    
    // Dynamic locators - Updated for current Amazon India UI (2026)
    private By productResults = By.cssSelector("div[data-component-type='s-search-result']");
    private By firstProductTitle = By.cssSelector("div[data-component-type='s-search-result'] h2 a span");
    private By productPrice = By.cssSelector("div[data-component-type='s-search-result'] span.a-price");
    private By filterSection = By.id("s-refinements");
    private By ratingStars = By.cssSelector("div[data-component-type='s-search-result'] .a-icon-star-small span");
    
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Get number of search results
     */
    public int getSearchResultsCount() {
        List<WebElement> results = driver.findElements(productResults);
        return results.size();
    }
    
    /**
     * Get first product title
     */
    public String getFirstProductTitle() {
        try {
            return getText(firstProductTitle);
        } catch (Exception e) {
            // Fallback: Try alternative title locator
            By alternativeTitle = By.cssSelector("div[data-component-type='s-search-result']:first-child .s-size-mini.s-color-base.s-underline-link-text");
            return getText(alternativeTitle);
        }
    }
    
    /**
     * Click on first product
     */
    public void clickFirstProduct() {
        try {
            // Try clicking on the link within the first product
            By firstProductLink = By.cssSelector("div[data-component-type='s-search-result'] h2 a");
            click(firstProductLink);
        } catch (Exception e) {
            // Fallback: Click on the title directly
            click(firstProductTitle);
        }
    }
    
    /**
     * Get first product price
     */
    public String getFirstProductPrice() {
        try {
            By firstProductPrice = By.cssSelector("div[data-component-type='s-search-result']:first-child span.a-price-whole");
            return getText(firstProductPrice);
        } catch (Exception e) {
            return "Price not available";
        }
    }
    
    /**
     * Verify search results are displayed
     */
    public boolean areSearchResultsDisplayed() {
        return getSearchResultsCount() > 0;
    }
}
