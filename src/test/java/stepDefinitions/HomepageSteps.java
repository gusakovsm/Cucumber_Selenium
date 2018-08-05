package stepDefinitions;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import pageObject.HomePage;
import reuseLib.WebDriverLib;

public class HomepageSteps {

	private WebDriverLib driver;
	private HomePage homePage;
	
    public HomepageSteps(WebDriverLib driver) {
        this.driver = driver;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }
    
    @Given("^I want to write a step with precondition$")
    public void i_am_on_the_home_page() throws Throwable {
    	driver.get(homePage.toString());
    }
}
