package com.fis.UIAutomationEbay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By cartCount = By.cssSelector("span.gh-badge");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartCount() {
        return driver.findElement(cartCount).getText();
    }
}