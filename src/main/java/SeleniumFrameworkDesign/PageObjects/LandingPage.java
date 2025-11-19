package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement username = driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"));

	//page factory
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordEle;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(id="login_Layer")
	WebElement loginNaukri;
	
	@FindBy(className="ml-3")
	WebElement loginLinkedin;
	
	public void LoggingAppication(String email, String password)
	{
		username.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
	
	public void goToNaukri()
	{
		driver.get("https://www.naukri.com/");
		loginNaukri.click();
	}
	
	public void goToLinkedin()
	{
		driver.get("https://www.linkedin.com/");
		loginLinkedin.click();
	}
}
