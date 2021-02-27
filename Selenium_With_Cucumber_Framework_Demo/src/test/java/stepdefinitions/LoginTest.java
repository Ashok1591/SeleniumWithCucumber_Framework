package stepdefinitions;

import org.junit.Assert;

import com.qa.demo.pageobjects.InitPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest extends InitPage {
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		navigateToLoginPage();
	}

	@Given("^Page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String pageTitle) throws Throwable {
		
		String title = demoLogin.getPageTitle();
		Assert.assertEquals(pageTitle, title);
	}
	
	@When("^User enters User Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_User_Email_as_and_Password_as(String email, String pass) throws Throwable {
	    
		demoLogin.insertEmail(email);
		demoLogin.insertPassword(pass);
	}

	@And("^Click on login$")
	public void click_on_login() throws Throwable {
		
		demoLogin.clickOnLogin();
	}

	@Then("^User should be redirected on \"([^\"]*)\"$")
	public void user_should_be_redirected_on(String pageTitle) throws Throwable {
		
		String title = demoLogin.getPageTitle();
		Assert.assertEquals(pageTitle, title);
	    
	}

}
