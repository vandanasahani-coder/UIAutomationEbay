package com.fir.UIAutomationEbay.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class WaitUtils {

	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // default 10 sec
	}

	// Wait for visibility
	public WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Wait for element to be clickable
	public WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Wait for presence in DOM (not necessarily visible)
	public WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// Wait for element to disappear
	public boolean waitForInvisibility(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	// Click with wait
	public void clickWhenReady(By locator) {
		waitForClickable(locator).click();
	}

	// Send keys after visibility
	public void sendKeysWhenVisible(By locator, String text) {
		WebElement element = waitForVisibility(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void waitForPageLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver)
				.executeScript("return document.readyState").equals("complete");

		wait.until(pageLoadCondition);
	}
	
	public void urlContains(String url) {
		wait.until(ExpectedConditions.urlContains(url));
	}
		
}
