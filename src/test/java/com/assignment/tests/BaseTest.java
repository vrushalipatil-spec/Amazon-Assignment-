package com.assignment.tests;

import org.openqa.selenium.WebDriver;
import com.assignment.utils.WebDriverFactory;
import com.assignment.utils.ConfigReader;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.assignment.utils.ScreenshotUtils;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeClass
    public void beforeClass() {
        config = new ConfigReader();
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createDriver(config.get("browser"));
        driver.manage().window().maximize();
        driver.get(config.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.capture(driver, result.getName());
        }
        if (driver != null) driver.quit();
    }
}
