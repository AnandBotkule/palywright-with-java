package cucumber;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;

import DummyAPI.MakingAPICall;
import PageObject.PGlogin;
import PageObject.Products;
import PageObject.loginPage;
import base.BaseComponent;
import base.PlaywrightDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition  extends BaseComponent{
	public loginPage loginpage;
	public PGlogin pgLogin;
	public Products products;
	public Page page;
	public MakingAPICall makingapicall;
	BaseComponent br=new BaseComponent();
	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		PlaywrightDriver.openPage("https://www.saucedemo.com/");
	}

	@When("I complete action")
	public void i_complete_action() {
	    // Write code here that turns the phrase above into concrete actions
		loginpage.loginPageofsauce();
	}

	@When("check more outcomes")
	public void check_more_outcomes() throws InterruptedException {
	    pgLogin.mousehoverlogin();
	    }

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		products.productscheck();
	}
	
	@Given("I want to write a step with API precondition")
	public void i_want_to_write_a_step_with_api_precondition() {
	    // Write code here that turns the phrase above into concrete actions
		makingapicall.SetupRequestContext();
	}
	@When("I API response action")
	public void i_api_response_action() {
	    makingapicall.getstatus();
	}

	@Then("I validate the API outcomes message")
	public void i_validate_the_api_outcomes_message() {
	    makingapicall.getMessage();
	    makingapicall.nameandsalary();
	}

}

