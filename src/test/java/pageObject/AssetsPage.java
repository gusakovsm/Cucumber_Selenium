package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import reuseLib.WebDriverLib;

public class AssetsPage extends Page{

	private WebDriverLib driver;
	
	@FindBy(how = How.XPATH, using = "//button[@class='flex-none mat-icon-button']")
	public WebElement buttonSearch;
	@FindBy(how = How.CSS, using = "input[placeholder='Search']")
	public WebElement fieldSearch;
	@FindBy(how = How.XPATH, using = "//button[@class='grid-refresh-button mat-icon-button ng-star-inserted']")
	public WebElement buttonRefresh;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary mat-mini-fab mat-accent ng-star-inserted']")
	public WebElement buttonAddNew;
	@FindBy(how = How.XPATH, using = "//div[@class='mat-tab-label mat-ripple mat-tab-label-active ng-star-inserted']")
	public WebElement buttonSingleValue;
	@FindBy(how = How.CSS, using = "input[placeholder='Asset name']")
	public WebElement fieldAssetName;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary mat-button']")
	public WebElement buttonAddAsset;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary mat-button']")
	public WebElement buttonCancel;
	@FindBy(how = How.XPATH, using = "//div[@class='ui-select-container dropdown open ng-star-inserted']")
	public WebElement fieldType;
	
	
	public AssetsPage() {
		super();
	}
	
    public void setDriver(WebDriverLib driver) {
        this.driver = driver;
    }
    
    public void ClickRefresh() {
     	driver.waitForElementPresent(buttonRefresh);
     	driver.waitForElementToBeClickable(buttonRefresh);
    	buttonRefresh.click();
    }
    
    public void AddNewAsset(String assetName, String value) {
    	driver.waitForElementPresent(buttonAddNew);
    	driver.waitForElementToBeClickable(buttonAddNew);
    	buttonAddNew.click();
    	driver.waitForElementPresent(buttonSingleValue);
    	buttonSingleValue.click();
    	driver.waitForElementPresent(fieldAssetName);
    	fieldAssetName.sendKeys(assetName);
    	driver.waitForElementPresent(fieldType);
    	fieldType.click();
       	driver.waitForElementPresent(By.xpath("//a[@class='dropdown-item']/div[text()='Text']"));
       	driver.findElement(By.xpath("//a[@class='dropdown-item']/div[text()='Text']")).click();
       	driver.waitForElementPresent(By.cssSelector("input[placeholder='Value']"));
       	driver.findElement(By.cssSelector("input[placeholder='Value']")).sendKeys(value);
       	driver.waitForElementPresent(buttonAddAsset);
       	driver.waitForElementToBeClickable(buttonAddAsset);
       	buttonAddAsset.click();
    }
    
    public void AddNewAsset(String assetName, Boolean value) {
    	driver.waitForElementPresent(buttonAddNew);
    	driver.waitForElementToBeClickable(buttonAddNew);
    	buttonAddNew.click();
    	driver.waitForElementPresent(buttonSingleValue);
    	buttonSingleValue.click();
    	driver.waitForElementPresent(fieldAssetName);
    	fieldAssetName.sendKeys(assetName);
    	driver.waitForElementPresent(fieldType);
    	fieldType.click();
       	driver.waitForElementPresent(By.xpath("//a[@class='dropdown-item']/div[text()='Bool']"));
       	driver.findElement(By.xpath("//a[@class='dropdown-item']/div[text()='Bool']")).click();
       	driver.waitForElementPresent(By.xpath("//mat-radio-group[@class='mat-radio-group']"));
       	if (value) {
       		driver.findElement(By.xpath("//mat-radio-group[@class='mat-radio-group']/mat-radio-button[1]")).click();
       	}
       	else
       	{
       		driver.findElement(By.xpath("//mat-radio-group[@class='mat-radio-group']/mat-radio-button[2]")).click();
       	}
       	driver.waitForElementPresent(buttonAddAsset);
       	buttonAddAsset.click();
    }
    
    public void AddNewAsset(String assetName, Integer value) {
    	driver.waitForElementPresent(buttonAddNew);
    	driver.waitForElementToBeClickable(buttonAddNew);
    	buttonAddNew.click();
    	driver.waitForElementPresent(buttonSingleValue);
    	buttonSingleValue.click();
    	driver.waitForElementPresent(fieldAssetName);
    	fieldAssetName.sendKeys(assetName);
    	driver.waitForElementPresent(fieldType);
    	fieldType.click();
       	driver.waitForElementPresent(By.xpath("//a[@class='dropdown-item']/div[text()='Integer']"));
       	driver.findElement(By.xpath("//a[@class='dropdown-item']/div[text()='Integer']")).click();
       	driver.waitForElementPresent(By.cssSelector("input[placeholder='Value']"));
       	driver.findElement(By.cssSelector("input[placeholder='Value']")).sendKeys(value.toString());
       	driver.waitForElementPresent(buttonAddAsset);
       	buttonAddAsset.click();
    }
    
    public void AddNewAsset(String assetName, String username, String password) {
    	driver.waitForElementPresent(buttonAddNew);
    	driver.waitForElementToBeClickable(buttonAddNew);
    	buttonAddNew.click();
    	driver.waitForElementPresent(buttonSingleValue);
    	buttonSingleValue.click();
    	driver.waitForElementPresent(fieldAssetName);
    	fieldAssetName.sendKeys(assetName);
    	driver.waitForElementPresent(fieldType);
    	fieldType.click();
       	driver.waitForElementPresent(By.xpath("//a[@class='dropdown-item']/div[text()='Credential']"));
       	driver.findElement(By.xpath("//a[@class='dropdown-item']/div[text()='Credential']")).click();
       	driver.waitForElementPresent(By.cssSelector("input[placeholder='Username']"));
       	driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
       	driver.waitForElementPresent(By.cssSelector("input[placeholder='Password']"));
       	driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
       	driver.waitForElementPresent(buttonAddAsset);
       	buttonAddAsset.click();
    }
    
    public void SearchAssets(String searchParameter) {
    	driver.waitForElementPresent(buttonSearch);
    	driver.waitForElementToBeClickable(buttonSearch);
    	buttonSearch.click();
    	driver.waitForElementPresent(fieldSearch);
    	fieldSearch.clear();
    	fieldSearch.sendKeys(searchParameter);
    	driver.waitForElementPresent(By.xpath("//tr[@class='ui-grid-row ng-star-inserted'][1]"));
    }

    
}
