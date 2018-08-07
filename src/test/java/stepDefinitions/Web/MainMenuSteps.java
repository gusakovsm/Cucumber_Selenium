package stepDefinitions.Web;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginPage;
import pageObject.MainMenu;
import reuseLib.WebDriverLib;

public class MainMenuSteps {

    private WebDriverLib driver;
	private LoginPage loginPage;
	private MainMenu mainmenu;

	public MainMenuSteps(WebDriverLib driver) {
        this.driver = driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.setDriver(driver);
        mainmenu = PageFactory.initElements(driver, MainMenu.class);
		mainmenu.setDriver(driver);
    }
    
	@Given("^I Open Orchestrator and Login into tenant \"([^\"]*)\" using login \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_open_Orchestrator_and_Login_into_tenant_using_login_and_password(String tenantName, String userName, String password) throws Throwable {
		driver.openBrowser("https://demo.uipath.com/account/login");
		loginPage.TypeLoginData(tenantName, userName, password);
	}

	@When("^I click \"([^\"]*)\" button$")
	public void i_click_button(String buttonName) throws Throwable {
		mainmenu.clickMenuButton(buttonName);
	}

	@Then("^Page URL should contain \"([^\"]*)\" end the URL end$")
	public void page_URL_should_contain(String url) throws Throwable {
		Assert.assertTrue(driver.getCurrentUrl().contains(url));
	}
	
	@When("^I click UiPath logo$")
	public void i_click_uipath_logo() {
		mainmenu.clickUiPathLogo();
	}
}
