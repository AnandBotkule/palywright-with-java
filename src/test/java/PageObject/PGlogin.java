package PageObject;

import org.testng.Assert;

import com.microsoft.playwright.Page;

import base.BaseComponent;

public class PGlogin extends BaseComponent {
	public static void mousehoverlogin() throws InterruptedException {
		Thread.sleep(2000);
		page.getByText("Sauce Labs Backpack").click();
		Thread.sleep(2000);
		page.locator("#add-to-cart").click();
	}

}
