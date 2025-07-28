package com.fis.UIAutomationEbay.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class SearchResultsPage {
    WebDriver driver;
    By firstItem = By.cssSelector("ul.srp-results li.s-card a.su-link");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

//    public void clickFirstItem() {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(firstItem));
//        driver.findElements(firstItem).get(0).click();
//    }
    
    public void clickFirstItem(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement firstItem = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("ul.srp-results li.s-item a.s-item__link")));
            firstItem.click();
            System.out.println("Clicked using s-item__link");
        } catch (TimeoutException e1) {
            System.out.println("First locator failed. Trying fallback...");
            try {
                WebElement fallbackItem = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("ul.srp-results li.s-card a.su-link")));
                fallbackItem.click();
                System.out.println("Clicked using su-link");
            } catch (TimeoutException e2) {
                System.out.println("Both locators failed.");
                e2.printStackTrace();
            }
        }
    }
}
