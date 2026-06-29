package SeleniumFrameworkDesign.PageObjects;

import java.io.IOException;
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

//	private static final String Freshness = null;
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
	
	@FindBy(className = "styles_btn-secondary__2AsIP")
	WebElement EnabledNextButton;

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
	
	public void filterApply(String location, String freshness, String freshnessID, String department) {
		
		for(int i = 0; i < filterContainer.size(); i++)
			{
				WebElement filter = filterContainer.get(i);
				String filterName = filter.findElement(By.cssSelector(".styles_filterHeading___hZQx")).getText();
				
				if(filterName.equals("Department"))
				{
					System.out.println("inside department");
					

					WebElement departmentFilter = driver.findElement(By.xpath("//label[@for='chk-Engineering - Software & QA-functionAreaIdGid-']"));
					departmentFilter.click();
//					WebElement deptCheckbox = driver.findElement(By.xpath("//i[@class='ni-icon-checked']"));
//					deptCheckbox.click();
//					boolean b = deptCheckbox.isSelected();
//					System.out.println(b);
//					if (!departmentFilter.isSelected())
//					{
//						System.out.println("INside again");
//						deptCheckbox.click();
//						System.out.println("Clicked");
////						
//					}
					waitForStaleness(filter);
				}
				
//				if(filterName.equals("Salary"))
//				{
//					if (!(driver.findElement(By.xpath("//span[@title='"+salary+"']"))).isSelected())
//					{
//						driver.findElement(By.xpath("//span[@title='"+salary+"']")).click();
//					}
//					waitForStaleness(filter);
//				}
				
				if(filterName.equals("Freshness"))
				{
				    WebElement freshnessFilter = driver.findElement(By.xpath("//div[@data-filter-id=\"freshness\"]//i[@class=\"ni-icon-arrow-down\"]"));

				    if (!freshnessFilter.isSelected())
				    {
				        freshnessFilter.click();
				        driver.findElement(By.xpath("//a[@data-id = \""+freshnessID+"\"]/span[text()='"+freshness+"']")).click();
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
									"kpi reports",
									"python", 
									"cucumber",
									"automation",
									"manual testing",
									"data management",
									"test execution",
									"automation testing","communication skills", "testing framework", "leadership", "version control",
									"debugging","etl", "database testing" );
							
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

	public void pagination() throws InterruptedException, IOException {
		int count = 1;
		WebElement nextButton = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
		scrollBy(nextButton);
		waitForElement(nextButton);
		boolean enabled = nextButton.isEnabled();
		System.out.println("Enable outside loop"+ enabled);
		while (enabled) {
			
//			TakeScreenshot("Pagination", driver);
			nextButton.click();
			count++;
			System.out.println(count);
			Thread.sleep(2000);
			this.jobKeywordsToApply();
			Thread.sleep(2000);
			nextButton = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
			scrollBy(nextButton);
			waitForElement(nextButton);
			enabled = nextButton.isEnabled();
			System.out.println("Enable in loop"+enabled);
			
//			if(nextButton.isSelected())
//			{
//				System.out.println("Button selected");
//			}
		}
	}

}
