package reuseLib;


import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverLib implements WebDriver{

	private static WebDriver driver;
	private static WebDriverWait wait;
    private final Map<String, String> temporaryValues = new HashMap<String, String>();
    private final LinkedHashMap<String, String> temporaryValuesSavedOrder = new LinkedHashMap<String, String>();

	public void openBrowser(String URL) {
			System.setProperty("webdriver.chrome.driver", "/Cucumber_Selenium/src/test/resources/drivers/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
	        wait = (WebDriverWait) new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class);
	}
    public void waitForElementPresent(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementPresent(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTextPresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForInvisibilityOfElement(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForVisibilityOfElementFromList(List<WebElement> list) {
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public void waitForInvisibilityOfElement(final WebElement element) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                if (!isElementPresent(element)) {
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    public void waitForExpectedSizeInList(final int expectedSize, final List<WebElement> list) {
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    if (list.size() == expectedSize) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });
        } catch (TimeoutException e) {
            Assert.fail("Expected size:<" + expectedSize + "> but was:<" + list.size() + ">");
        }
    }

    public boolean isElementPresent(By by) {
        if (driver.findElements(by).size() > 0) {
            driver.findElement(by);
            if (driver.findElement(by).isDisplayed()) {
                if (driver.findElement(by).isEnabled()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.getTagName();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    public void addTemporaryProperty(String key, String value) {
        temporaryValues.put(key, value);
    }

    public void addTemporaryPropertySavingOrder(String key, String value) {
        temporaryValuesSavedOrder.put(key, value);
    }

    public String getTemporaryProperty(String key) {
        return temporaryValues.get(key);
    }

    public String getTemporaryPropertySavedOrder(String key) {
        return temporaryValuesSavedOrder.get(key);
    }

    public Set<String> getTemporaryPropertyKey() {
        return temporaryValues.keySet();
    }

    public int getTemporaryPropertySize() {
        return temporaryValues.size();
    }

    public int getTemporaryValuesSavedOrderSize() {
        return temporaryValuesSavedOrder.size();
    }

    public Collection<String> getTemporaryPropertyValues() {
        return temporaryValues.values();
    }

    public Collection<String> getTemporaryPropertyValuesSavedOrder() {
        return temporaryValuesSavedOrder.values();
    }

    public void clearTemporaryProperty() {
        temporaryValues.clear();
    }

    public void clearTemporaryPropertySavedOrder() {
        temporaryValuesSavedOrder.clear();
    }

    public void close() {
        driver.close();
    }

    public WebElement findElement(By arg0) {
        return driver.findElement(arg0);
    }

    public List<WebElement> findElements(By arg0) {
        return driver.findElements(arg0);
    }

    public void get(String arg0) {
        driver.get(arg0);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public Options manage() {
        return driver.manage();
    }

    public Navigation navigate() {
        return driver.navigate();
    }

    public void quit() {
        driver.quit();
    }

    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("scroll(250,0);");
    }

    public void scrollDown() {
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    public void clearLocalStorage() {
        ((JavascriptExecutor) driver).executeScript("localStorage.clear()");
    }

    public void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.build().perform();
    }

    public byte[] captureScreenshot() throws IOException {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public String getSelectedDropdownOption(WebElement dropdown) {
        return new Select(dropdown).getFirstSelectedOption().getText();
    }
    
    public void selectByIndex(WebElement element, Integer index) {
    	Select dropdown = new Select(element);
    	dropdown.selectByIndex(index);
    }
    
    public void selectByValue(WebElement element, String value) {
    	Select dropdown = new Select(element);
    	dropdown.selectByValue(value);
    }
    
    public void selectByVisibleText(WebElement element, String text) {
    	Select dropdown = new Select(element);
    	dropdown.selectByVisibleText(text);
    }

}