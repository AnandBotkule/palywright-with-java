package PageObject;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import base.BaseComponent;


public class loginPage extends BaseComponent{
	public static void loginPageofsauce() {
		type("username", "standard_user");
		type("password", "secret_sauce");
		click("login");
		isElementPresent("title");
		Assert.assertTrue(isElementPresent("title"));
		page.getByText("Sauce Labs Backpack");
	}
	
}
