package SeleniumFrameworkDesign.PageObjects;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class JobSearch extends AbstractComponents {

	WebDriver driver;
	int expectedPercentage = 35;
	
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
	
	@FindBy(css=".styles_filterContainer__4aQaD")
	List<WebElement> filterContainer;
	
	@FindBy(css=".cust-job-tuple div h2")
	List<WebElement> jobReferals;
	
	@FindBy(xpath="//button[(text(), 'Apply')]")
	WebElement applyButton;
	
	@FindBy(id="apply-button")
	WebElement applyOnCompanySiteButton;
	
	@FindBy(className = "styles_JDC__job-highlight-list__QZC12")
	WebElement jobHighlight;
	
	
	public void goToJobSearch(String job,String location) {
		jobsearchEditor.click();
		jobKeyword.sendKeys(job);
		locations.sendKeys(location);
		searchButton.click();
	}
	
	public void goToRecommendedJob() {
		Actions action = new Actions(driver);
		action.moveToElement(jobSearchLink).build().perform();
		recommendedJob.click();
	}
	
	public void filterApply(String department, String salary, String roleCategory, String location ) {
		
		for(int i = 0; i < filterContainer.size(); i++)
			{
				WebElement filter = filterContainer.get(i);
				
				String filterName = filter.findElement(By.cssSelector(".styles_filterHeading___hZQx")).getText();
				if(filterName.equals("Department"))
				{
					if (!(driver.findElement(By.xpath("//span[@title='" + department + "']"))).isSelected())
					{
						driver.findElement(By.xpath("//span[@title='" + department + "']")).click();
					}
					waitForStaleness(filter);
				}
				
				if(filterName.equals("Salary"))
				{
					if (!(driver.findElement(By.xpath("//span[@title='"+salary+"']"))).isSelected())
					{
						driver.findElement(By.xpath("//span[@title='"+salary+"']")).click();
					}
					waitForStaleness(filter);
				}
					
//				if(filterName.equals("Role category"))
//				{
//					if (!(driver.findElement(By.xpath("//span[@title='"+roleCategory+"']"))).isSelected())
//					{
//						driver.findElement(By.xpath("//span[@title='"+roleCategory+"']")).click();
//					}
//					else break;
//					waitForStaleness(filter);
//				}
				
				if(filterName.equals("Location"))
				{
					if (!(driver.findElement(By.xpath("//span[@title='"+location+"']"))).isSelected())
					{
						driver.findElement(By.xpath("//span[@title='"+location+"']")).click();
					}
					waitForStaleness(filter);
				}
			}
	}
	
	public void jobKeywordsToApply() {
		
		int z= 0;
		for(int j=0;j<jobReferals.size();j++)
		{
			WebElement referal = jobReferals.get(j);
			String text = referal.getText().toLowerCase().trim(); 
			
			if(text.contains("qa") || text.contains("quality assurance") || text.contains("automation tester"))
					{
						int x = 0;
						WebElement button = null;
						referal.click();
						
						Set<String> windows = driver.getWindowHandles();
						Iterator<String> it = windows.iterator();
						String parentId = it.next();
						String childId = it.next();
						
						driver.switchTo().window(childId);
						
						List<WebElement> keySkills = driver.findElements(By.cssSelector(".styles_key-skill__GIPn_ div a"));
						
						int y = keySkills.size();
						int count = 0;
					
						System.out.println("y = "+y);
						for (WebElement keySkill: keySkills)
						{
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
									"test plan",
									"sprint",
									"user stories",
									"jenkins",
									"maven",
									"scrum master",
									"rest api",
									"KPI reports");
							
							for(String defKeySkill: defKeySkills)
							{
								if(skills.contains(defKeySkill.toLowerCase()))
								{
									x+=1;
								}
							}
						}
						System.out.println("x = "+x);
						double percentage = ((double)x/y)*100;
						System.out.println(percentage);
						if(percentage>= expectedPercentage && (button == applyButton ||button == applyOnCompanySiteButton ))
						{
							if(button == applyButton) {
								applyButton.click();
							}
							else if(button == applyOnCompanySiteButton) {
								count =+1;
							}
						driver.findElement(By.xpath("//button[contains(text(), 'Apply')]")).click();
						z+=1;
						}
						driver.switchTo().window(parentId);
					}
		}
		System.out.println("Applied for "+z+" applications");
		
	}

}
