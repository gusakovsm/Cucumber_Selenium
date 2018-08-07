package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import reuseLib.WebDriverLib;

public class ResetPasswordPage {
	
	private WebDriverLib driver;
	@FindBy(how = How.CSS, using = "input[placeholder='Tenant name']")
	public WebElement fieldTenantName;
	@FindBy(how = How.CSS, using = "input[placeholder='Username or email']")
	public WebElement fieldUsername;
	@FindBy(how = How.CSS, using = "div.action-button-container > button")
	public WebElement buttonResetPassword;

	public ResetPasswordPage() {
		super();
	}
	
    public void setDriver(WebDriverLib driver) {
        this.driver = driver;
    }
	
	public void ResetPassword(String tenant, String username) {
		driver.waitForElementPresent(fieldTenantName);
		fieldTenantName.sendKeys(tenant);
		driver.waitForElementPresent(fieldUsername);
		fieldUsername.sendKeys(username);
		buttonResetPassword.click();
	}
}
