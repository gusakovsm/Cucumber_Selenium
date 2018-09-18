package stepDefinitions.Web;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.Header;
import pageObject.LoginPage;
import pageObject.ResetPasswordPage;
import reuseLib.WebDriverLib;

public class LoginPageSteps {
	private WebDriverLib driver;
	private LoginPage loginPage;
	private Header header;
	private ResetPasswordPage resetpasswordPage;

	
    public LoginPageSteps(WebDriverLib driver) {
        this.driver = driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        header = PageFactory.initElements(driver, Header.class);
    	resetpasswordPage = PageFactory.initElements(driver, ResetPasswordPage.class);
    	header.setDriver(driver);
    	loginPage.setDriver(driver);
    	resetpasswordPage.setDriver(driver);
    }
       
    @Given("^I want to open Orchestrator$")
    public void i_want_to_open_Orchestrator() throws Throwable {
    	driver.openBrowser("https://demo.uipath.com/account/login");
    	driver.waitForElementPresent(loginPage.loginHeaderText);
    }
    
    @Given("^I see \"([^\"]*)\" page title$")
    public void i_see_login_page(String pageTitle) throws Throwable {
    	driver.waitForTitleExist(pageTitle);
    }

    @When("^I type into tenant \"([^\"]*)\", login \"([^\"]*)\", password \"([^\"]*)\" and press login$")
    public void i_type_credentials_and_press_login(String tenantName, String userName, String password) throws Throwable {
    	loginPage.TypeLoginData(tenantName, userName, password);
    }
    
    @When("^I click become a tenant$")
    public void i_click_become_a_tenant() throws Throwable {
    	loginPage.OpenNewTenantPage();
    }
    
    @When("^I click reset passowrd$")
    public void i_click_reset_passowrd() throws Throwable {
    	loginPage.OpenResetPasswordPage();
    }
    
    @When("^I type tenant \"([^\"]*)\", login \"([^\"]*)\" and click reset$")
    public void i_type_tenant_login_and_click_reset(String tenantName, String userName) throws Throwable {
    	resetpasswordPage.ResetPassword(tenantName, userName);
    }
    
    @When("^I click Terms and conditions$")
    public void i_click_Terms_and_conditions() throws Throwable {
    	loginPage.OpenLicenseAgreement();
    }
    
    @Then("^I see error message \"([^\"]*)\"$")
    public void i_see_error_message(String errorMessage) throws Throwable {
    	driver.waitForElementPresent(loginPage.fieldErrorMessage);
    	loginPage.fieldErrorMessage.getText().contains(errorMessage);
    }
    
    @Then("^I LogOut$")
    public void i_LogOut() throws Throwable {
    	header.PressLogOut();
    }
    
    @Then("^I close Orchestrator$")
    public void i_close_Orchestrator() throws Throwable {
    	driver.quit();
    }
    
    @Then("^I go back$")
    public void i_go_back() throws Throwable {
    	driver.navigate().back();
    }
    
    @Then("^I see license agreement page \"([^\"]*)\"$")
    public void i_see_license_agreement_page(String URL) throws Throwable {
    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        assertEquals(URL, driver.getCurrentUrl());
    }
    
    @Then("^I close this tab$")
    public void i_close_this_tub() throws Throwable {
    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(1));
    	driver.close();
    	driver.switchTo().window(tabs.get(0));
    }
    
}
