package SeleniumFrameworkDesign.PageObjects;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class UpdateProfile extends AbstractComponents {
	
	WebDriver driver;
	
	public UpdateProfile(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page factory
	
	@FindBy(className="nI-gNb-icon-img")
	WebElement profilePerformance;
	
	@FindBy(css=".nI-gNb-de__perf-card")
	List<WebElement> labels;
	
	@FindBy(className="cross-icon")
	WebElement closeButton;
	
	@FindBy(css=".ni-gnb-icn-cross-drawer")
	WebElement closePerformancePageDrawer;
	
	By profilePerform = By.cssSelector(".nI-gNb-icon-img");
	By pageLabel = By.cssSelector(".nI-gNb-de__perf-card-label");
	By count = By.cssSelector(".nI-gNb-de__perf-card-count");
	
	
	public void goToPerformancePage()
	{
		waitForByElement(profilePerform);
		profilePerformance.click();
	}
	
	public void closeNaukriProPopup()
	{
		closeButton.click();
	}
	
	public void closePerformancePage()
	{
		closePerformancePageDrawer.click();
	}
	
	public String[] recruiterActionCount() throws InterruptedException
	{
		sleepDuration(1000);
		String[] recruiterActn= new String[2];
		
		for(WebElement label:labels) {
			
			if(label.findElement(pageLabel).getText().equals("Recruiter Actions"))
			{
				recruiterActn[0] = label.findElement(count).getText();
			}
			}
		
		System.out.println(recruiterActn[0]);
		recruiterActn[1]= LocalDate.now().toString(); 
		System.out.println(recruiterActn[1]);
		return recruiterActn;		
	}
	
	public String[] searchAppearanceCount()
	{
		String[] searchApp= new String[2];
		
		for(WebElement label:labels) {
		if(label.findElement(pageLabel).getText().equals("Search Appearances"))
		{
			searchApp[0] = label.findElement(count).getText();
		}
		}
		System.out.println(searchApp[0]);
		
		searchApp[1]= LocalDate.now().toString(); 
		System.out.println(searchApp[1]);
		return searchApp;
	}

}
