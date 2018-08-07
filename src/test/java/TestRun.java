
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

//import pageObject.Header;
//import pageObject.LoginPage;
import pageObject.*;
import reuseLib.WebDriverLib;

public class TestRun {
	
  	public static void main(String[] args) throws IOException, InterruptedException {
  		
  		
        WebDriverLib driver = new WebDriverLib();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.setDriver(driver);
        MainMenu menu = PageFactory.initElements(driver, MainMenu.class);
        menu.setDriver(driver);
        AssetsPage assets = PageFactory.initElements(driver, AssetsPage.class);
        assets.setDriver(driver);
               
        driver.openBrowser("https://demo.uipath.com/account/login");
        loginPage.TypeLoginData("TA_Andromeda", "admin", "Qwerty123");
        menu.clickMenuButton("assets");

  	}
}






    


