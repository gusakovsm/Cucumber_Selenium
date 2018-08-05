package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends Page{
	
	@FindBy(how = How.XPATH, using = "//input[@id='mat-input-0']")
	public WebElement fieldTenantName;
	@FindBy(how = How.XPATH, using = "//input[@id='mat-input-1']")
	public WebElement fieldUsername;
	@FindBy(how = How.XPATH, using = "//input[@id='mat-input-2']")
	public WebElement fieldPassword;
	@FindBy(how = How.XPATH, using = "//button[@class='mat-raised-button mat-primary']")
	public WebElement buttonLogin;
	
	public LoginPage() {
		super();
	}
	
	public void TypeLoginData(String tenantName, String userName, String password) {
		fieldTenantName.sendKeys(tenantName);
		fieldUsername.sendKeys(userName);
		fieldPassword.sendKeys(password);
		buttonLogin.click();
	}
	

}
