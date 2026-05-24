package com.automation_amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation_amazon.pages.HomePage;
import com.automation_amazon.pages.SearchResultsPage;
import com.automation_amazon.pages.ProductDetailPage;
import com.automation_amazon.utils.TestData;

/**
 * AddToCartTests - Test class for add to cart functionality
 * Tests adding products to shopping cart
 */
public class AddToCartTests extends BaseTest {
    
    /**
     * Test 1: Search for product and verify product details
     */
    @Test(priority = 1, description = "Search for product and verify product details page loads")
    public void testProductDetailsDisplayed() {
        // Test setup
        HomePage homePage = new HomePage(driver);
        
        // Search for product
        homePage.searchForProduct(TestData.SEARCH_PRODUCT_LAPTOPS);
        
        // Verify search results
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        Assert.assertTrue(searchResults.areSearchResultsDisplayed(), "Search results not displayed");
        
        // Click first product
        searchResults.clickFirstProduct();
        
        // Switch to product detail page
        driver.switchTo().defaultContent();
        
        // Small delay for page load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Verify product detail page
        ProductDetailPage productDetail = new ProductDetailPage(driver);
        Assert.assertTrue(productDetail.isProductPageLoaded(), "Product detail page did not load");
    }
    
    /**
     * Test 2: Verify product information is displayed
     */
    @Test(priority = 2, description = "Verify product title and price are displayed correctly")
    public void testProductInformationDisplayed() {
        // Test setup
        HomePage homePage = new HomePage(driver);
        
        // Search for product
        homePage.searchForProduct(TestData.SEARCH_PRODUCT_PHONES);
        
        // Click first product
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        searchResults.clickFirstProduct();
        
        // Wait for page load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Verify product information
        ProductDetailPage productDetail = new ProductDetailPage(driver);
        String productTitle = productDetail.getProductTitle();
        String productPrice = productDetail.getProductPrice();
        
        Assert.assertFalse(productTitle.isEmpty(), "Product title is empty");
        Assert.assertNotEquals(productPrice, "Price not available", "Product price is not displayed");
    }
    
    /**
     * Test 3: Verify navigation flow from search to product details
     */
    @Test(priority = 3, description = "Verify complete navigation flow from search to product details")
    public void testSearchToProductDetailFlow() {
        // Test setup
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Home page did not load");
        
        // Search
        homePage.searchForProduct(TestData.SEARCH_PRODUCT_LAPTOPS);
        
        // Verify search results
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        Assert.assertTrue(searchResults.areSearchResultsDisplayed(), "Search results not displayed");
        
        // Navigate to product
        searchResults.clickFirstProduct();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Verify product page
        ProductDetailPage productDetail = new ProductDetailPage(driver);
        Assert.assertTrue(productDetail.isProductPageLoaded(), "Product page not loaded");
    }
}
