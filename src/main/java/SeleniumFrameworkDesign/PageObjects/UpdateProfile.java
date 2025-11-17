package SeleniumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfile {
	
	WebDriver driver;
	
	public UpdateProfile(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page factory
	
	@FindBy(className="nI-gNb-icon-img")
	WebElement profilePerformance;
	
	public void goToPerformancePage()
	{
		profilePerformance.click();
	}
	
	
	public void searchCountCheck()
	{
		
		
		String searchApp = "";
		String RecruiterActn="";
		
		List<WebElement> labels = driver.findElements(By.cssSelector(".nI-gNb-de__perf-card"));
		
		labels.stream().filter(label->label.findElement(By.cssSelector(".nI-gNb-de__perf-card-label")).getText().equals("Search Appearances"));
		
		for(WebElement label:labels) {
			
			if (label.findElement(By.cssSelector(".nI-gNb-de__perf-card-label")).getText().equals("Search Appearances"))
			{
				searchApp = label.findElement(By.cssSelector(".nI-gNb-de__perf-card-count")).getText();
			}
			else if(label.findElement(By.cssSelector(".nI-gNb-de__perf-card-label")).getText().equals("Recruiter Actions"))
			{
				RecruiterActn = label.findElement(By.cssSelector(".nI-gNb-de__perf-card-count")).getText();
			}
			}
		
//		System.out.println(searchApp);
//		System.out.println(RecruiterActn);
	
		
		//closing the pop-up
		driver.findElement(By.cssSelector(".ni-gnb-icn-cross-drawer")).click();
	}
	


}
