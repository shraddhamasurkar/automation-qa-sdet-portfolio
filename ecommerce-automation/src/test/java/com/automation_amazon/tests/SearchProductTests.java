package com.automation_amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation_amazon.pages.HomePage;
import com.automation_amazon.pages.SearchResultsPage;
import com.automation_amazon.utils.TestData;
import com.automation_amazon.utils.ExtentReportManager;

/**
 * SearchProductTests - Test class for search functionality
 * Tests product search with different keywords
 */
public class SearchProductTests extends BaseTest {
    
    /**
     * Test 1: Search for laptops and verify results
     */
    @Test(priority = 1, description = "Search for laptops and verify search results are displayed")
    public void testSearchForLaptops() {
        // Test setup
        HomePage homePage = new HomePage(driver);
        
        // Verify home page loaded
        Assert.assertTrue(homePage.isHomePageLoaded(), "Home page did not load");
        
        // Perform search
        homePage.searchForProduct(TestData.SEARCH_PRODUCT_LAPTOPS);
        
        // Verify search results
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        Assert.assertTrue(searchResults.areSearchResultsDisplayed(), "Search results are not displayed");
        
        // Verify number of results
        int resultsCount = searchResults.getSearchResultsCount();
        Assert.assertTrue(resultsCount > 0, "No search results found for laptops");
    }
    
    /**
     * Test 2: Search for iPhones and verify first product
     */
    @Test(priority = 2, description = "Search for iPhones and verify first product details")
    public void testSearchForPhones() {
        // Test setup
        HomePage homePage = new HomePage(driver);
        
        // Perform search
        homePage.searchForProduct(TestData.SEARCH_PRODUCT_PHONES);
        
        // Verify search results
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        Assert.assertTrue(searchResults.areSearchResultsDisplayed(), "Search results are not displayed");
        
        // Get first product title
        String firstProductTitle = searchResults.getFirstProductTitle();
        Assert.assertFalse(firstProductTitle.isEmpty(), "First product title is empty");
    }
    
    /**
     * Test 3: Verify search result count for books
     */
    @Test(priority = 3, description = "Search for books and verify result count")
    public void testSearchForBooks() {
        // Test setup
        HomePage homePage = new HomePage(driver);
        
        // Perform search
        homePage.searchForProduct(TestData.SEARCH_PRODUCT_BOOKS);
        
        // Verify search results
        SearchResultsPage searchResults = new SearchResultsPage(driver);
        int resultsCount = searchResults.getSearchResultsCount();
        
        // Assert result count
        Assert.assertTrue(resultsCount > 0, "No results found for automation testing books");
    }
}
