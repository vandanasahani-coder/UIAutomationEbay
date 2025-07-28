package com.fis.UIAutomationEbay.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import com.fir.UIAutomationEbay.utils.WaitUtils;


public class ProductPage {
    WebDriver driver;
    WaitUtils waitUtils = new WaitUtils(driver);
    By addToCartBtn = By.id("atcBtn_btn_1");
    By closePopupButtons = By.xpath("//button[@aria-label='Close' or contains(@class, 'close') or contains(@class,'dialog__close')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    
    
    
}