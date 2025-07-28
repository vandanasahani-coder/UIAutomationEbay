package com.fis.UIAutomationEbay;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent.attachReporter(spark);
    }

    @BeforeClass
    public void setup() {
        // No need to set System property - Selenium 4 auto-handles driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
