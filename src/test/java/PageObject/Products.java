package PageObject;

import org.testng.Assert;

import com.microsoft.playwright.Page;

import base.BaseComponent;


public class Products extends BaseComponent {
	public static void productscheck() throws InterruptedException {
		Thread.sleep(2000);
		page.getByText("Sauce Labs Backpack").click();
		Thread.sleep(2000);
		page.locator(".inventory_details_price").textContent();
		boolean price=page.locator(".inventory_details_price").isVisible();
		Assert.assertTrue(price);
	}
}
