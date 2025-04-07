package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;


public class BaseComponent {


	
	
	public static Page page;
	
	
	public BaseComponent() {
		page = PlaywrightDriver.getPage();
		
		
	}

	
	public static void click(String locatorKey) {

		try {
			page.locator(PlaywrightDriver.OR.getProperty(locatorKey)).click();
		} catch (Throwable t) {

			Assert.fail(t.getMessage());
		}
	}
	
	
	public static void mouseHover(String locatorKey) {

		try {
			page.hover(PlaywrightDriver.OR.getProperty(locatorKey));
		} catch (Throwable t) {

				Assert.fail(t.getMessage());
		}
	}

	public static boolean isElementPresent(String locatorKey) {

		try {
			page.waitForSelector(PlaywrightDriver.OR.getProperty(locatorKey));

				return true;
		} catch (Throwable t) {

	
			return false;
		}

	}

	public static void type(String locatorKey, String value) {
		try {
			page.locator(PlaywrightDriver.OR.getProperty(locatorKey)).fill(value);
		} catch (Throwable t) {

				Assert.fail(t.getMessage());
		}
	}

	
	public static void select(String locatorKey, String value) {
		try {
			page.selectOption(PlaywrightDriver.OR.getProperty(locatorKey),new SelectOption().setLabel(value));
			} catch (Throwable t) {

			Assert.fail(t.getMessage());
		}
	}
	
	
	
	
}
	
