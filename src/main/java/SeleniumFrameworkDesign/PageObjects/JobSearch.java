package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class JobSearch extends AbstractComponents {

	WebDriver driver;
	
	
	public JobSearch(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory components
	@FindBy(css=".nI-gNb-custom-Jobs")
	WebElement jobSearchLink;
	
	@FindBy(xpath = "//div[text()='Recommended jobs']")
	WebElement recommendedJob;
	
	@FindBy(css = ".nI-gNb-sb__placeholder")
	WebElement jobsearchEditor;
	
	@FindBy(css = ".suggestor-input")
	WebElement jobKeyword;
	
	@FindBy(xpath = "//input[@placeholder='Enter location']")
	WebElement locations;
	
	@FindBy(xpath = "//span[text()='Search']")
	WebElement searchButton;
	
	
	public void goToJobSearch(String job,String location) {
		jobsearchEditor.click();
		jobKeyword.sendKeys(job);
		locations.sendKeys(location);
		searchButton.click();
	}
	
	public void goToRecommendedJob() {
		goToHomePage();
		Actions action = new Actions(driver);
		action.moveToElement(jobSearchLink).build().perform();
		recommendedJob.click();
	}

}
