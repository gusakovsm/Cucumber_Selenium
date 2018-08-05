package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import reuseLib.WebDriverLib;

public class RobotsPage extends Page{
	
	WebDriverLib driver;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary mat-mini-fab mat-accent ng-star-inserted']")
	public WebElement buttonAdd;
	@FindBy(how = How.XPATH, using = "//input[@name='licenseKey']")
	public WebElement fieldKey;
	@FindBy(how = How.XPATH, using = "//input[@name='machineName']")
	public WebElement fieldMachine;
	@FindBy(how = How.XPATH, using = "//input[@name='name']")
	public WebElement fieldName;
	@FindBy(how = How.XPATH, using = "//input[@name='userName']")
	public WebElement fieldDomainUsername;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public WebElement fieldPassword;
	@FindBy(how = How.XPATH, using = "//ng-select[@class='ng-valid']/div[@class='ui-select-container dropdown open ng-star-inserted']")
	public WebElement dropboxType;
	@FindBy(how = How.XPATH, using = "//input[@name='description']")
	public WebElement fieldDescription;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary mat-button']")
	public WebElement buttonProvision;
	@FindBy(how = How.XPATH, using = "//li[1]/div/a/div")
	public WebElement nonproductionOption;
	@FindBy(how = How.XPATH, using = "//li[2]/div/a/div")
	public WebElement unattendedOption;
	@FindBy(how = How.XPATH, using = "//li[3]/div/a/div")
	public WebElement attendedOption;
	@FindBy(how = How.XPATH, using = "//li[4]/div/a/div")
	public WebElement developmentOption;
	

	
	public RobotsPage() {
		super();
	}
	
	public String CreateNewRobot(String machine, String name, String domain, String password, String description) {
		buttonAdd.click();
		fieldMachine.sendKeys(machine);
		fieldName.sendKeys(name);
		fieldDomainUsername.sendKeys(domain);
		fieldPassword.sendKeys(password);
		fieldDescription.sendKeys(description);
		dropboxType.click();
		developmentOption.click();
		String key = fieldKey.getText();
		buttonProvision.click();
		return key;
	}
}
