package com.fis.UIAutomationEbay;

import org.testng.annotations.*;
import com.fir.UIAutomationEbay.utils.WaitUtils;
import com.fis.UIAutomationEbay.pages.*;
import static org.testng.Assert.*;

public class AddToCartTest extends BaseTest {
	HomePage homePage;
	SearchResultsPage resultsPage;
	ProductPage productPage;
	CartPage cartPage;
	WaitUtils waitUtils;

	@Test(dataProvider = "searchItems")
	public void verifyAddToCart(String keyword) throws InterruptedException {
		test = extent.createTest("Verify Add to Cart for: " + keyword);
		driver.get("https://www.ebay.com/");

		homePage = new HomePage(driver);
		resultsPage = new SearchResultsPage(driver);
		productPage = new ProductPage(driver);
		cartPage = new CartPage(driver);
		waitUtils = new WaitUtils(driver);
		waitUtils.waitForPageLoad();
		test.info("Searching for item: " + keyword);
		homePage.searchFor(keyword);
		waitUtils.urlContains("_nkw=book");
		waitUtils.waitForPageLoad();

		test.info("Clicking first search result");
		resultsPage.clickFirstItem(driver);

		// Switch to new tab
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		test.info("Adding item to cart");
		productPage.addToCart();

		driver.navigate().to("https://www.ebay.com/");
		Thread.sleep(10000);
		String cartCount = cartPage.getCartCount();

		test.info("Verifying cart count: " + cartCount);
		assertTrue(Integer.parseInt(cartCount) > 0, "Cart should have at least 1 item");
		test.pass("Cart updated successfully for search term: " + keyword);
	}

	@DataProvider(name = "searchItems")
	public Object[][] getSearchKeywords() {
		return new Object[][] { { "book" } };
	}
}
