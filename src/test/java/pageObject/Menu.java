package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Menu extends Page{

	@FindBy(how = How.XPATH, using = "//a[@class='block relative mat-list-item ng-star-inserted' and @href='/robots']")
	private WebElement buttonRobots;
	@FindBy(how = How.XPATH, using = "//a[@class='block relative mat-list-item ng-star-inserted' and @href='/processes']")
	private WebElement buttonProcesses;
	@FindBy(how = How.XPATH, using = "//a[@class='block relative mat-list-item ng-star-inserted' and @href='/jobs']")
	private WebElement buttonJobs;
	@FindBy(how = How.XPATH, using = "//a[@class='block relative mat-list-item ng-star-inserted' and @href='/schedules']")
	private WebElement buttonSchedules;
	@FindBy(how = How.XPATH, using = "//a[@class='block relative mat-list-item ng-star-inserted' and @href='/assets']")
	private WebElement buttonAssets;
	@FindBy(how = How.XPATH, using = "//a[@class='block relative mat-list-item ng-star-inserted' and @href='/queues']")
	private WebElement buttonQueues;
	
	public Menu() {
		super();
	}
	
	public void openRobotsPage() {
		buttonRobots.click();
	}
	
	public void openProcessesPage() {
		buttonRobots.click();
	}
	
	public void openJobsPage() {
		buttonRobots.click();
	}
	
	public void openSchedulesPage() {
		buttonRobots.click();
	}
	
	public void openAssetsPage() {
		buttonRobots.click();
	}	
	
	public void openQueuesPage() {
		buttonRobots.click();
	}
}
