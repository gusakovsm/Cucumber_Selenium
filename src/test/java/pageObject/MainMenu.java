package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import reuseLib.WebDriverLib;

public class MainMenu extends Page{

	private WebDriverLib driver;
	
	@FindBy(how = How.CSS, using = "#FullLogo")
	public WebElement logoUiPath;
	
	public MainMenu() {
		super();
	}
	
    public void setDriver(WebDriverLib driver) {
        this.driver = driver;
    }
	
	public void clickMenuButton(String buttonName) {
		driver.waitForElementPresent(By.id("FullLogo"));
		driver.findElement(By.xpath("//a[@class='block relative mat-list-item ng-star-inserted' and @href='/" + buttonName +"']")).click();
	}
	
	public void clickUiPathLogo() {
		driver.waitForElementPresent(logoUiPath);
		logoUiPath.click();
	}
	
}
