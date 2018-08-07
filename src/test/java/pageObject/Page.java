package pageObject;

import reuseLib.WebDriverLib;

public class Page {
	
	private WebDriverLib driver;
	
	public void setDriver(WebDriverLib driver) {
		this.driver = driver;
	}
	
	public String getPageURL(WebDriverLib driver) {
		return driver.getCurrentUrl();
	}


	
}
