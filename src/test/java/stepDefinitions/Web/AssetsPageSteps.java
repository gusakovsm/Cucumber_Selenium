package stepDefinitions.Web;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.AssetsPage;
import reuseLib.WebDriverLib;

public class AssetsPageSteps {
	
	private WebDriverLib driver;
	private AssetsPage assetPage;
	
    public AssetsPageSteps(WebDriverLib driver) {
        this.driver = driver;
        assetPage = PageFactory.initElements(driver, AssetsPage.class);
    	assetPage.setDriver(driver);
    }
    
    @When("^I create new asset \"([^\"]*)\" with String type and value \"([^\"]*)\"$")
    public void i_create_new_asset_with_String_type_and_value(String assetName, String value) throws Throwable {
    	assetPage.AddNewAsset(assetName, value);
    	driver.waitForInvisibilityOfElement(assetPage.buttonAddAsset);
    }
    
    @When("^I create new asset \"([^\"]*)\" with Integer type and value (\\d+)$")
    public void i_create_new_asset_with_Integer_type_and_value(String assetName, int value) throws Throwable {
    	assetPage.AddNewAsset(assetName, value);
    	driver.waitForInvisibilityOfElement(assetPage.buttonAddAsset);
    }

    @When("^I create new asset \"([^\"]*)\" with Boolean type and value \"([^\"]*)\"$")
    public void i_create_new_asset_with_Boolean_type_and_value(String assetName, String value) throws Throwable {
    	Boolean convertedvalue = Boolean.valueOf(value);
    	assetPage.AddNewAsset(assetName, convertedvalue);
    	driver.waitForInvisibilityOfElement(assetPage.buttonAddAsset);
    }

    @When("^I create new asset \"([^\"]*)\" with Credentials type, username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_create_new_asset_with_Credentials_type_username_and_password(String assetName, String username, String password) throws Throwable {
    	assetPage.AddNewAsset(assetName, username, password);
    	driver.waitForInvisibilityOfElement(assetPage.buttonAddAsset);
    }
    
    @Then("^I search created asset by asset name \"([^\"]*)\" and check that asset with this value exist$")
    public void i_search_created_asset_by_value(String searchParameter) throws Throwable {
    	assetPage.SearchAssets(searchParameter);
    	List<WebElement> listElem = driver.findElements(By.xpath("//tr[@class='ui-grid-row ng-star-inserted']"));
        assertEquals(true, listElem.size()>0);
        Boolean result = null;
        for (Integer i=0; i<listElem.size(); i++) {
        	if (listElem.get(i).getText().contains(searchParameter)) {
        		result = listElem.get(i).getText().contains(searchParameter);
        		break;
        	}
        }
        assertEquals(true, result);
        driver.findElement(By.xpath("//mat-icon[@svgicon='uipath:StatusCanceling']")).click();
    }


}
