
package SampadaTraining.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkDesign.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyOnLinkedin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToNaukri();
		landingPage.LoggingAppication("sampadasdesai@gmail.com", "Sampada@410");
		
		driver.manage().window().maximize();
		
		
		
		//Job search
		
		driver.findElement(By.xpath("//li-icon[@type='job']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='organization-title']")).sendKeys("Quality Assurance engineer");
		Thread.sleep(3000);
		driver.findElement(By.id("jobs-search-box-location-id-ember198")).sendKeys("Pune");
		
		
		// after login
//		driver.findElement(By.className("nI-gNb-icon-img")).click();
//		
//		String searchApp = "";
//		String RecruiterActn="";
//		
//		List<WebElement> labels = driver.findElements(By.cssSelector(".nI-gNb-de__perf-card"));
//		
//		labels.stream().filter(label->label.findElement(By.cssSelector(".nI-gNb-de__perf-card-label")).getText().equals("Search Appearances"));
//		
//		for(WebElement label:labels) {
//			
//			if (label.findElement(By.cssSelector(".nI-gNb-de__perf-card-label")).getText().equals("Search Appearances"))
//			{
//				searchApp = label.findElement(By.cssSelector(".nI-gNb-de__perf-card-count")).getText();
//			}
//			else if(label.findElement(By.cssSelector(".nI-gNb-de__perf-card-label")).getText().equals("Recruiter Actions"))
//			{
//				RecruiterActn = label.findElement(By.cssSelector(".nI-gNb-de__perf-card-count")).getText();
//			}
//			}
//		
//		System.out.println(searchApp);
//		System.out.println(RecruiterActn);
//	
//		
//		//closing the pop-up
//		driver.findElement(By.cssSelector(".ni-gnb-icn-cross-drawer")).click();
//		
//		//edit details on profile page
//		driver.findElement(By.className("view-profile-wrapper")).click();
//		
//		WebElement resumeHL = driver.findElement(By.cssSelector(".resumeHeadline"));
//		resumeHL.findElement(By.cssSelector(".edit")).click();
//		
//		//resume headline edit page
//		WebElement headliner = driver.findElement(By.id("resumeHeadline"));
//		headliner.clear();
//		headliner.sendKeys("Experienced QA Professional | Expertise in System & Automation Testing | Strong Analytical, Communication, and Project Management Skills");
//		
//		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		
//		
//		//jobs search
//		
//		driver.get("https://www.naukri.com/mnjuser/homepage");
//		WebElement jobSearch = driver.findElement(By.cssSelector(".nI-gNb-custom-Jobs"));
//		WebElement recommendedJob = driver.findElement(By.xpath("//div[text()='Recommended jobs']"));
//		
//		Actions action = new Actions(driver);
//		action.moveToElement(jobSearch).build().perform();
//		recommendedJob.click();
//		
////		driver.findElement(By.xpath("a[text()='Recommended jobs']")).click();
//		
//		//Jobsearch from search option
//		
//		WebElement jobsearchEditor = driver.findElement(By.cssSelector(".nI-gNb-sb__placeholder"));
//		
//		jobsearchEditor.click();
//		driver.findElement(By.cssSelector(".suggestor-input")).sendKeys("Quality assurance engineer");
//		driver.findElement(By.xpath("//input[@placeholder='Enter location']")).sendKeys("Pune");
//		driver.findElement(By.xpath("//span[text()='Search']")).click();
//		
////		filters for job search
//		
////		//check the filters
////		
////		if ((driver.findElement(By.xpath("//span[@title='Quality Assurance']"))).isSelected())
////		{
////			System.out.println("is selected");
////		}
////		else
////		{
////			driver.findElement(By.xpath("//span[@title='Quality Assurance']")).click();
////		}
////		
//		
//		List<WebElement> filters = driver.findElements(By.cssSelector(".styles_filterContainer__4aQaD"));
//		
//		for(WebElement filter:filters)
//		{
//			if(filter.findElement(By.xpath(".//span[text()='Department']")).equals("Department"))
//			{
//				System.out.println("inside loop1");
//				if (!(driver.findElement(By.xpath("//span[@title='Quality Assurance']"))).isSelected())
//				{
//					System.out.println("inside loop2 department");
//					driver.findElement(By.xpath("//span[@title='Quality Assurance']")).click();
//				}
//				
//			}
//			
////			if(filter.findElement(By.xpath(".//span[text()='Salary']")).size() > 0)
////			{
////				
////			}
////				
////			if(filter.findElement(By.xpath(".//span[text()='Role category']")).size() > 0)
////			{
////				
////			}
////			
////			if(filter.findElement(By.xpath(".//span[text()='Location']")).size() > 0)
////			{
////				
////			}
////			
//			
//		}
//	
}
}