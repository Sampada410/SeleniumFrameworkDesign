package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class ProfileEditPage extends AbstractComponents{

	WebDriver driver;
	
	public ProfileEditPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//pageFactory components
	@FindBy(className = "view-profile-wrapper")
	WebElement profileLink;
	
	@FindBy(css = ".resumeHeadline")
	WebElement resumeHL;
	
	@FindBy(id = "resumeHeadline")
	WebElement headliner;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	
	By editButton = By.cssSelector(".edit");

			
			
	public void userProfilePage()
	{
		waitForElement(profileLink);
		profileLink.click();
	}
	
	public void editProfile()
	{
		resumeHL.findElement(editButton).click();
	}

	public void resumeHeadlineEdit()
	{
		headliner.clear();
		headliner.sendKeys("Quality Assurance Professional | Skilled in Automation testing, and End-to-End Quality Strategies | Strong Analytical, Communication & Project Management Skills | Dedicated Professional Focused on Efficiency, Quality, and Continuous Improvement");
	}
	
	public void saveButton()
	{
		saveButton.click();
	}
}
