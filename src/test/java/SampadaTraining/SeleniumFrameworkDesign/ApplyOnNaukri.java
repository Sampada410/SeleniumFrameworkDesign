package SampadaTraining.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworkDesign.PageObjects.JobSearch;
import SeleniumFrameworkDesign.PageObjects.LandingPage;
import SeleniumFrameworkDesign.PageObjects.ProfileEditPage;
import SeleniumFrameworkDesign.PageObjects.UpdateProfile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyOnNaukri {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String[] recruiterAction= new String[2];
		String[] searchProfile = new String[2];
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToNaukri();
		landingPage.LoggingAppication("sampadasdesai@gmail.com", "Sampada@4");
		
		driver.manage().window().maximize();
		
		UpdateProfile updateProfile = new UpdateProfile(driver);
		updateProfile.goToPerformancePage();
		recruiterAction = updateProfile.recruiterActionCount();
//		System.out.println(Arrays.toString(recruiterAction));
		searchProfile = updateProfile.searchAppearanceCount();
//		System.out.println(Arrays.toString(searchProfile));
		updateProfile.closePerformancePage();
		
		ProfileEditPage editProfile = new ProfileEditPage(driver);
		editProfile.userProfilePage();
		editProfile.editProfile();
		editProfile.resumeHeadlineEdit();
		editProfile.saveButton();

		JobSearch jobSearchPage = new JobSearch(driver);
		jobSearchPage.goToRecommendedJob();
		jobSearchPage.goToJobSearch("Manual test manager", "Pune");
		
				
//		filters for job search
		
		for(int i = 0; i < driver.findElements(By.cssSelector(".styles_filterContainer__4aQaD")).size(); i++)
//		for(WebElement filter:filters)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 
			List<WebElement> filters = driver.findElements(By.cssSelector(".styles_filterContainer__4aQaD"));
			WebElement filter = filters.get(i);
			
			String filterName = filter.findElement(By.cssSelector(".styles_filterHeading___hZQx")).getText();
//			System.out.println(filterName);
//			if(filterName.equals("Department"))
//			{
//				if (!(driver.findElement(By.xpath("//span[@title='Quality Assurance']"))).isSelected())
//				{
//					driver.findElement(By.xpath("//span[@title='Quality Assurance']")).click();
//				}
//				wait.until(ExpectedConditions.stalenessOf(filter));
//			}
			
//			if(filterName.equals("Salary"))
//			{
//				if (!(driver.findElement(By.xpath("//span[@title='25-50 Lakhs']"))).isSelected())
//				{
//					driver.findElement(By.xpath("//span[@title='25-50 Lakhs']")).click();
//				}
//				wait.until(ExpectedConditions.stalenessOf(filter));
//			}
				
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
		
		List<WebElement> jobReferals = driver.findElements(By.cssSelector(".cust-job-tuple div h2"));
		int z= 0;
		for(int j=0;j<jobReferals.size();j++)
		{
			WebElement referal = jobReferals.get(j);
			
//			System.out.println(referal);
			
			String text = referal.getText().toLowerCase().trim(); 
//			System.out.println(text);
			
			if(text.contains("qa") || text.contains("quality assurance") || text.contains("automation tester"))
					{
						referal.click();
						
						Set<String> windows = driver.getWindowHandles();
						Iterator<String> it = windows.iterator();
						String parentId = it.next();
						String childId = it.next();
						
						driver.switchTo().window(childId);
						
						List<WebElement> keySkills = driver.findElements(By.cssSelector(".styles_key-skill__GIPn_ div a"));
						int x = 0;
						int y = keySkills.size();
					
						System.out.println("y = "+y);
						for (WebElement keySkill: keySkills)
						{
//							System.out.println(keySkill);
							String skills = keySkill.getText().toLowerCase();
							
							List<String> defKeySkills = Arrays.asList(
									"selenium",
									"java",
									"git",
									"quality Assurance",
									"agile",
									"testing",
									"postman",
									"api",
									"azure",
									"sql",
									"stlc",
									"qa automation",
									"sdlc",
									"communication skills",
									"jira",
									"testing concept",
									"test plan");
							
							for(String defKeySkill: defKeySkills)
							{
								if(skills.contains(defKeySkill.toLowerCase()))
								{
									x+=1;
								}
							}
							
//							if (skills.contains("selenium"))
//							{
//								x+=1;
//							}
//							if (skills.contains("java"))
//							{
//								x+=1;
//							}
//							if (skills.contains("git"))
//							{
//								x+=1;
//							}
//							if (skills.contains("quality Assurance"))
//							{
//								x+=1;
//							}
//							if (skills.contains("agile"))
//							{
//								x+=1;
//							}
//							if (skills.contains("testing"))
//							{
//								x+=1;
//							}
//							if (skills.contains("postman"))
//							{
//								x+=1;
//							}
//							if (skills.contains("api"))
//							{
//								x+=1;
//							}
//							if (skills.contains("azure"))
//							{
//								x+=1;
//							}
//							if (skills.contains("sql"))
//							{
//								x+=1;
//							}
						}
						System.out.println("x = "+x);
						double percentage = ((double)x/y)*100;
						System.out.println(percentage);
						if(percentage>=60)
						{
						driver.findElement(By.xpath("//button[contains(text(), 'Apply')]")).click();
						z+=1;
						}
						driver.switchTo().window(parentId);
					}
//			System.out.println("Applied for "+z+"applications");
		}
		System.out.println("Applied for "+z+" applications");
		
	
}
}