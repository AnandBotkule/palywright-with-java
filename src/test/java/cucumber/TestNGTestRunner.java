package cucumber;



import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/cucumber/",glue="Stepdefinitions",
monochrome=true, publish=true, plugin= {"pretty","html:target/cucumber.html",
		                                  "json:target/cucumberreport.json",
		                                  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

                                           
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
}