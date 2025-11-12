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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("sampadasdesai@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sampada@4");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// after login
		driver.findElement(By.className("nI-gNb-icon-img")).click();
		
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
		
		System.out.println(searchApp);
		System.out.println(RecruiterActn);
	
		
		//closing the pop-up
		driver.findElement(By.cssSelector(".ni-gnb-icn-cross-drawer")).click();
		
		//edit details on profile page
		driver.findElement(By.className("view-profile-wrapper")).click();
		
		WebElement resumeHL = driver.findElement(By.cssSelector(".resumeHeadline"));
		resumeHL.findElement(By.cssSelector(".edit")).click();
		
		//resume headline edit page
		WebElement headliner = driver.findElement(By.id("resumeHeadline"));
		headliner.clear();
		headliner.sendKeys("Experienced QA Professional | Expertise in System & Automation Testing | Strong Analytical, Communication, and Project Management Skills");
		
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		
		//jobs search
		
		driver.get("https://www.naukri.com/mnjuser/homepage");
		WebElement jobSearch = driver.findElement(By.cssSelector(".nI-gNb-custom-Jobs"));
		WebElement recommendedJob = driver.findElement(By.xpath("//div[text()='Recommended jobs']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(jobSearch).build().perform();
		recommendedJob.click();
		
//		driver.findElement(By.xpath("a[text()='Recommended jobs']")).click();
		
		//Jobsearch from search option
		
		WebElement jobsearchEditor = driver.findElement(By.cssSelector(".nI-gNb-sb__placeholder"));
		
		jobsearchEditor.click();
		driver.findElement(By.cssSelector(".suggestor-input")).sendKeys("Quality assurance engineer");
		driver.findElement(By.xpath("//input[@placeholder='Enter location']")).sendKeys("Pune");
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		
//		filters for job search
		
		for(int i = 0; i < driver.findElements(By.cssSelector(".styles_filterContainer__4aQaD")).size(); i++)
//		for(WebElement filter:filters)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 
			List<WebElement> filters = driver.findElements(By.cssSelector(".styles_filterContainer__4aQaD"));
			WebElement filter = filters.get(i);
			
			String filterName = filter.findElement(By.cssSelector(".styles_filterHeading___hZQx")).getText();
			System.out.println(filterName);
//			if(filterName.equals("Department"))
//			{
//				if (!(driver.findElement(By.xpath("//span[@title='Quality Assurance']"))).isSelected())
//				{
//					driver.findElement(By.xpath("//span[@title='Quality Assurance']")).click();
//				}
//				wait.until(ExpectedConditions.stalenessOf(filter));
//			}
			
			if(filterName.equals("Salary"))
			{
				if (!(driver.findElement(By.xpath("//span[@title='25-50 Lakhs']"))).isSelected())
				{
					driver.findElement(By.xpath("//span[@title='25-50 Lakhs']")).click();
				}
				wait.until(ExpectedConditions.stalenessOf(filter));
			}
				
			if(filterName.equals("Role category"))
			{
				if (!(driver.findElement(By.xpath("//span[@title='Quality Assurance and Testing']"))).isSelected())
				{
					driver.findElement(By.xpath("//span[@title='Quality Assurance and Testing']")).click();
				}
				wait.until(ExpectedConditions.stalenessOf(filter));
			}
			
			if(filterName.equals("Location"))
			{
				if (!(driver.findElement(By.xpath("//span[@title='Pune']"))).isSelected())
				{
					driver.findElement(By.xpath("//span[@title='Pune']")).click();
				}
				wait.until(ExpectedConditions.stalenessOf(filter));
			}

			
			
		}
		
		//job application
		
		List<WebElement> jobReferals = driver.findElements(By.cssSelector(".srp-jobtuple-wrapper"));
		
		for(int j=0;j<jobReferals.size();j++)
		{
			WebElement referal = jobReferals.get(j);
			
			System.out.println(referal);
			
			String text = referal.findElement(By.xpath("//div/div/h2/a")).getText(); 
			System.out.println(text);
			
		}
	
}
}