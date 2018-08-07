package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import reuseLib.WebDriverLib;


public class LoginPage extends Page{
	
	private WebDriverLib driver;
	
	@FindBy(how = How.XPATH, using = "//input[@id='mat-input-0']")
	public WebElement fieldTenantName;
	@FindBy(how = How.XPATH, using = "//input[@id='mat-input-1']")
	public WebElement fieldUsername;
	@FindBy(how = How.XPATH, using = "//input[@id='mat-input-2']")
	public WebElement fieldPassword;
	@FindBy(how = How.XPATH, using = "//button[@class='mat-raised-button mat-primary']")
	public WebElement buttonLogin;
	@FindBy(how = How.XPATH, using = "//a[@class='button-flat-attn mat-button']")
	public WebElement buttonBecomeATenant;
	@FindBy(how = How.XPATH, using = "//a[@href='/account/passwordreset']")
	public WebElement buttonResetPassword;
	@FindBy(how = How.XPATH, using = "//a[@class='toc-link ng-star-inserted']")
	public WebElement buttonLicenseAgreement;
	
	
	public LoginPage() {
		super();
	}
	
    public void setDriver(WebDriverLib driver) {
        this.driver = driver;
    }
	
	public void TypeLoginData(String tenantName, String userName, String password) {
		driver.waitForElementPresent(fieldTenantName);
		fieldTenantName.clear();
		fieldTenantName.sendKeys(tenantName);
		driver.waitForElementPresent(fieldUsername);
		fieldUsername.clear();
		fieldUsername.sendKeys(userName);
		driver.waitForElementPresent(fieldPassword);
		fieldPassword.clear();
		fieldPassword.sendKeys(password);
		driver.waitForElementPresent(buttonLogin);
		buttonLogin.click();
	}
	
	public void OpenNewTenantPage() {
		driver.waitForElementPresent(buttonBecomeATenant);
		buttonBecomeATenant.click();
	}
	
	public void OpenResetPasswordPage() {
		driver.waitForElementPresent(buttonResetPassword);
		buttonResetPassword.click();
	}
	
	public void OpenLicenseAgreement() {
		driver.waitForElementPresent(buttonLicenseAgreement);
		buttonLicenseAgreement.click();
	}
	

}
