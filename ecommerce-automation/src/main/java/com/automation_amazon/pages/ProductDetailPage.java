package com.automation_amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ProductDetailPage - Page Object for Product Detail Page
 * Demonstrates dynamic locators for product interactions
 */
public class ProductDetailPage extends BasePage {
    
    // Dynamic locators - Updated for current Amazon India product pages (2026)
    private By productTitle = By.id("productTitle");
    private By productPrice = By.cssSelector("span.a-price-whole");
    private By productRating = By.cssSelector("span[data-a-icon-base='star'] span.a-icon-star-small");
    private By addToCartButton = By.id("add-to-cart-button");
    private By buyNowButton = By.id("buy-now-button");
    private By quantity = By.id("quantity");
    private By productImage = By.id("landingImage");
    
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    
    /**
     * Get product title
     */
    public String getProductTitle() {
        return getText(productTitle);
    }
    
    /**
     * Get product price
     */
    public String getProductPrice() {
        try {
            return getText(productPrice);
        } catch (Exception e) {
            return "Price not available";
        }
    }
    
    /**
     * Add product to cart
     */
    public void addToCart() {
        click(addToCartButton);
    }
    
    /**
     * Verify product page loaded
     */
    public boolean isProductPageLoaded() {
        return isElementDisplayed(productTitle);
    }
    
    /**
     * Select quantity
     */
    public void selectQuantity(String qty) {
        sendKeys(quantity, qty);
    }
}
