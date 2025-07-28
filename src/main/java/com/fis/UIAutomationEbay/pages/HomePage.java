package com.fis.UIAutomationEbay.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

public class HomePage {
    WebDriver driver;
    By searchBox = By.id("gh-ac");
    By searchButton = By.id("gh-search-btn");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
        driver.findElement(searchButton).click();
    }
}

