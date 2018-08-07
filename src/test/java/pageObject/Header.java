package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import reuseLib.WebDriverLib;

public class Header extends Page {
	
	private WebDriverLib driver;
	
	@FindBy(how = How.ID, using = "FullLogo")
	private WebElement imgLogo;
	@FindBy(how = How.XPATH, using = "//a[@href='https://orchestrator.uipath.com/v2018.1/']")
	private WebElement buttonHelp;
	@FindBy(how = How.XPATH, using = "//div[@class='td-notification-content']")
	private WebElement buttonAlerts;
	@FindBy(how = How.XPATH, using = "//div[@class='ng-star-inserted']")
	private WebElement buttonUser;
	@FindBy(how = How.XPATH, using = "//a[@href='/profile']")
	private WebElement buttonProfile;
	@FindBy(how = How.XPATH, using = "//a[@href='/settings']")
	private WebElement buttonSettings;
	@FindBy(how = How.XPATH, using = "//a[@href='/license']")
	private WebElement buttonLicense;
	@FindBy(how = How.XPATH, using = "//a[@href='/users']")
	private WebElement buttonUsers;
	@FindBy(how = How.XPATH, using = "//a[@href='/audit']")
	private WebElement buttonAudit;
	@FindBy(how = How.XPATH, using = "//a[@class='mat-menu-item' and @uiclicktrack='Action: Logout']")
	private WebElement buttonLogOut;

	
	public Header() {
		super();
	}
	
    public void setDriver(WebDriverLib driver) {
        this.driver = driver;
    }
	
	public void OpenHelpPage() {
		driver.waitForElementPresent(imgLogo);
		buttonHelp.click();
	}
	
	public void OpenAlerts() {
		driver.waitForElementPresent(imgLogo);
		buttonAlerts.click();
	}
	
	public void OpenUser() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
	}
	
	public void OpenProfilePage() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
		buttonProfile.click();
	}
	
	public void OpenSettingPage() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
		buttonSettings.click();
	}
	
	public void OpenLicencePage() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
		buttonLicense.click();
	}

	public void OpenUsersPage() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
		buttonUsers.click();
	}

	public void OpenAuditPage() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
		buttonAudit.click();
	}
	
	public void PressLogOut() {
		driver.waitForElementPresent(imgLogo);
		buttonUser.click();
		driver.waitForElementPresent(buttonLogOut);
		buttonLogOut.click();
	}
	

}



