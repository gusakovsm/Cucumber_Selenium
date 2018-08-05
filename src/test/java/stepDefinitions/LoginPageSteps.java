package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginPage;
import reuseLib.WebDriverLib;

public class LoginPageSteps {
	private WebDriverLib driver;
	private LoginPage loginPage;
	private String tenantName;
	private String userName;
	private String password;
	
    public LoginPageSteps(WebDriverLib driver) {
        this.driver = driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }
    
    @Given("^I want to open Orchestrator$")
    public void i_want_to_open_Orchestrator() throws Throwable {
    	driver.openBrowser("https://demo.uipath.com/account/login");
    }
    
    @Given("^Login into tenant \"([^\"]*)\" using login \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void login_into_tenant_using_login_and_password(String tenantName, String userName, String password) throws Throwable {
    	this.tenantName = tenantName;
    	this.userName = userName;
    	this.password = password;
    }

    @When("^I type credentials and press login$")
    public void i_type_credentials_and_press_login() throws Throwable {
    	loginPage.TypeLoginData(tenantName, userName, password);
    }

    @Then("^I see Orchestrator Home page$")
    public void i_see_Orchestrator_Home_page() throws Throwable {
    	driver.waitForElementPresent(By.id("FullLogo"));
    	assertEquals("UiPath Orchestrator Community", driver.getTitle());
    }

    @Then("^I see Orchestrator Login page$")
    public void i_see_Orchestrator_Login_page() throws Throwable {
    	assertEquals("Login - UiPath Orchestrator Community", driver.getTitle());
    }
    
    @Then("^I close Orchestrator$")
    public void i_close_Orchestrator() throws Throwable {
    	driver.quit();
    }
}
