package cucumber;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import base.PlaywrightDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class Hooks {

	public Page page;
	public Browser browser;
	@Before
	public void setUp() {
		
		PlaywrightDriver.setupDriver();
		
	}
	
	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			page = PlaywrightDriver.getPage();
			byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./screenshot/screenshot.png")));
			scenario.attach(screenshot, "image/png", "screenshot");
		
		
		}
		if(PlaywrightDriver.getBrowser()!=null) {
			PlaywrightDriver.closeBrowser();
		}
		PlaywrightDriver.quitPlaywright();
	}
}
