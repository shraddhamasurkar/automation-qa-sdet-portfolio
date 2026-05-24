# E-Commerce Automation - Selenium + TestNG Framework + AI Adaptation

A professional, production-ready test automation framework for Amazon India using **Selenium WebDriver**, **TestNG**, and **Page Object Model (POM)** along with improvement using **Github Copilot** to resolve the bugs . This project demonstrates enterprise-level **AI adaptation** in automation practices suitable for SDET roles.

## 📋 Project Overview

This framework showcases:
- ✅ **Page Object Model (POM)** - Maintainable and scalable test structure
- ✅ **Dynamic Locators** - Real-world element identification strategies
- ✅ **Explicit Waits** - Robust element interaction handling
- ✅ **TestNG Framework** - Data-driven, parameterized, and grouped test execution
- ✅ **Extent Reports** - Professional HTML test reporting
- ✅ **AI adaptation** - Resolving the dependecy and wrong locators issues using Copilot
- ✅ **Cross-browser Support** - Chrome and Firefox compatibility
- ✅ **Maven Project** - Industry-standard build and dependency management

## 🏗️ Project Structure

```
ecommerce-automation/
├── src/
│   ├── main/java/com/automation_amazon/
│   │   ├── pages/                    # Page Object Model classes
│   │   │   ├── BasePage.java         # Parent class with common methods
│   │   │   ├── HomePage.java         # Home page with search functionality
│   │   │   ├── SearchResultsPage.java # Search results with dynamic locators
│   │   │   └── ProductDetailPage.java # Product details page
│   │   ├── utils/                    # Utility classes
│   │   │   ├── DriverFactory.java    # WebDriver initialization
│   │   │   ├── WaitHelper.java       # Explicit wait utilities
│   │   │   ├── TestData.java         # Test data constants
│   │   │   └── ExtentReportManager.java # Report generation
│   │   └── config/
│   │       └── Config.java           # Configuration settings
│   └── test/java/com/automation_amazon/tests/
│       ├── BaseTest.java             # Parent test class with setup/teardown
│       ├── SearchProductTests.java   # Search functionality tests
│       └── AddToCartTests.java       # Product and cart tests
├── screenshots/                      # Test execution screenshots
├── test-output/                      # Extent Reports output
├── pom.xml                           # Maven dependencies and build config
├── testng.xml                        # TestNG suite configuration
└── README.md                         # This file
```

## 🛠️ Technologies & Dependencies

| Component | Version | Purpose |
|-----------|---------|---------|
| Selenium WebDriver | 4.15.0 | Browser automation |
| TestNG | 7.8.1 | Test framework |
| WebDriverManager | 5.6.3 | Automatic driver management |
| Extent Reports | 5.1.1 | HTML test reporting |
| Java | 11+ | Programming language |
| Maven | 3.8+ | Build tool |
| Copilot |Buidling agents |Fixing the code with Copilot

## 📦 Installation & Setup

### Prerequisites
- Java 11 or higher
- Maven 3.8+
- Git

### Step 1: Clone/Download the Project
```bash
cd ecommerce-automation
```

### Step 2: Install Dependencies
```bash
mvn clean install
```

### Step 3: Verify Setup
```bash
mvn --version
java -version
```

## ▶️ Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn clean test -Dtest=SearchProductTests
```

### Run Specific Test Method
```bash
mvn clean test -Dtest=SearchProductTests#testSearchForLaptops
```

### Run Tests with Firefox Browser
```bash
mvn clean test -Dbrowser=firefox
```

### Run Tests in Headless Mode
```bash
# Edit Config.java and set HEADLESS_MODE = true
mvn clean test
```
## Resolve your doubts with SeleniumTestNGAgent
location (.github/agents/SeleniumTestNGAgent.md)
Function: Helps for resolving errors and cross checks the lcoators ID. Monitors all the below test cases

## 📊 Test Suite Details

### Search Product Tests (3 Tests)
| Test | Purpose | Assertions |
|------|---------|-----------|
| testSearchForLaptops | Search functionality with laptops | Verify home page loaded, search executed, results displayed |
| testSearchForPhones | Search with different keyword | Verify search results count > 0 |
| testSearchForBooks | Search for books | Verify first product title is not empty |

### Add to Cart Tests (3 Tests)
| Test | Purpose | Assertions |
|------|---------|-----------|
| testProductDetailsDisplayed | Verify product page loads | Verify product detail page is loaded |
| testProductInformationDisplayed | Verify product info visibility | Verify title and price are displayed |
| testSearchToProductDetailFlow | End-to-end navigation flow | Complete search to product detail journey |

## 📈 Generated Reports

After test execution, view the Extent Report:
```bash
# Report is generated in: test-output/Report_<date_time>.html
# Open in browser to view detailed results
```

### Report Includes:
- ✅ Test execution summary (passed/failed/skipped)
- ✅ Detailed step-by-step logs
- ✅ Timestamps and execution duration
- ✅ System information (browser, OS, base URL)
- ✅ Pass/Fail status with detailed error messages

## 🎯 Key Features Demonstrated

### 1. Page Object Model (POM)
- Separation of concerns: UI elements vs test logic
- Reusable page methods across test classes
- Centralized locator management
- Easy maintenance and updates

### 2. Dynamic Locators (Amazon India)
```java
// Example from SearchResultsPage.java
private By productResults = By.xpath("//div[@data-component-type='s-search-result']");
private By firstProductTitle = By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]");
```

### 3. Explicit Waits
```java
// WaitHelper handles element visibility, clickability, and presence
waitHelper.waitForElementToBeClickable(locator).click();
waitHelper.waitForElementToBeVisible(locator);
```

### 4. TestNG Annotations
```java
@BeforeMethod      // Setup before each test
@AfterMethod       // Teardown after each test
@Test              // Mark test method
priority           // Control test execution order
description        // Add test description
```

### 5. Cross-browser Support
```java
// Switch browsers via command line or Config.java
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=chrome
```

## 🔧 Configuration

Edit `Config.java` to customize:
```java
// Base URL
public static final String BASE_URL = "https://www.amazon.in";

// Timeouts
public static final long IMPLICIT_WAIT = 10;
public static final long EXPLICIT_WAIT = 15;

// Browser
public static final boolean HEADLESS_MODE = false;

// Test data
public static final String SEARCH_QUERY = "laptop";
```

## 📝 Best Practices Implemented

1. ✅ **Single Responsibility** - Each class has one clear purpose
2. ✅ **DRY Principle** - Reusable methods in BasePage and utilities
3. ✅ **Waits over Sleep** - Explicit waits instead of Thread.sleep()
4. ✅ **Centralized Configuration** - All settings in Config.java
5. ✅ **Descriptive Assertions** - Clear failure messages
6. ✅ **Proper Exception Handling** - Try-catch for robustness
7. ✅ **Test Independence** - No dependencies between tests
8. ✅ **Professional Reporting** - Extent Reports for stakeholders

## 🚀 Future Enhancements

- [ ] Parameterized tests with @DataProvider
- [ ] BDD framework (Cucumber/Gherkin syntax)
- [ ] API testing integration
- [ ] Database validation tests
- [ ] Performance testing with JMeter
- [ ] CI/CD pipeline (GitHub Actions/Jenkins)
- [ ] Docker containerization
- [ ] Allure Reports integration
- [ ] Parallel test execution
- [ ] Test data management system

## 🤝 Contributing

This is a portfolio project. For improvements:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/enhancement`)
3. Commit your changes (`git commit -m 'Add enhancement'`)
4. Push to the branch (`git push origin feature/enhancement`)
5. Open a Pull Request

## 📚 Learning Resources

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/)
- [TestNG Official Guide](https://testng.org/doc/)
- [Page Object Model Pattern](https://selenium.dev/documentation/test_practices/encouraged/page_object_models/)
- [Extent Reports](https://extentreports.com/)

## ⚠️ Troubleshooting

### WebDriver Manager Issues
```bash
# Clear WebDriver cache
rm -rf ~/.wdm/  # Linux/Mac
rmdir %APPDATA%\.wdm /s  # Windows
mvn clean install
```

### Port Already in Use
```bash
# If ChromeDriver port conflicts, update Config.java with unique port
```

### Element Not Found
- Check if selectors match current Amazon UI
- Update locators in respective Page classes
- Use browser DevTools to inspect elements

## 📞 Support & Feedback

For questions or suggestions, please refer to the main portfolio repository documentation.

## 📄 License

This project is part of a professional portfolio and is open for educational purposes.

---

**Last Updated:** May 2026  
**Status:** Production-Ready ✅  
**Maintainer:** QA/SDET Portfolio Builder

