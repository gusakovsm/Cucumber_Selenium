import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


import pageObject.LoginPage;
import pageObject.Menu;
import pageObject.RobotsPage;
import reuseLib.WebDriverLib;

public class TestRun {

  	public static void main(String[] args) throws IOException {

        WebDriverLib driver = new WebDriverLib();
        LoginPage loginPage = new LoginPage();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        Menu menu = new Menu();
        menu = PageFactory.initElements(driver, Menu.class);
        RobotsPage robotPage = new RobotsPage();
        robotPage = PageFactory.initElements(driver, RobotsPage.class);
        
        driver.openBrowser("https://demo.uipath.com/account/login");
        System.out.println(driver.getTitle());
        loginPage.TypeLoginData("TA_Andromeda", "admin", "Qwerty123");
        driver.waitForElementPresent(By.id("FullLogo"));
        System.out.println(driver.getTitle());
        assertEquals("UiPath Orchestrator Community", driver.getTitle());
        menu.openRobotsPage();
        String text = robotPage.CreateNewRobot("test", "test", "test", "test", "test");
        System.out.println(text);
    }

}






    


