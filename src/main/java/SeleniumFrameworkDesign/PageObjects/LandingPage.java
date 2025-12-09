package SeleniumFrameworkDesign.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//page factory
	
	@FindBy(xpath="//input[@placeholder='Enter your active Email ID / Username']")
	WebElement usernameNK;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordNK;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(id="login_Layer")
	WebElement loginNaukri;
	
	@FindBy(className="ml-3")
	WebElement loginLinkedin;
	
	@FindBy(id="username")
	WebElement usernameLN;
	
	@FindBy(id="password")
	WebElement passwordLN;
	
	@FindBy(css =".server-err")
	WebElement errorMsg;
	
	@FindBy(xpath="//label[contains(text(),'Email')]/following-sibling::div[@class=\"err\"]")
	WebElement blankUsernameErrorMsg;
	
	@FindBy(xpath="//label[contains(text(),'Password')]/following-sibling::div[@class=\"err\"]")
	WebElement blankPasswordErrorMsg;
	
	public void LoggingAppication(String email, String password)
	{
		usernameNK.sendKeys(email);
		passwordNK.sendKeys(password);
		submit.click();
	}
	
	public void goToNaukri()
	{
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		loginNaukri.click();
	}
	
	public void goToLinkedin()
	{
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		loginLinkedin.click();
		
	}
	
	public void LoggingAppicationLN(String email, String password) throws InterruptedException
	{
		usernameLN.sendKeys(email);
		passwordLN.sendKeys(password);
		submit.click();
		
	}
	
	public String getErrorMessage()
	{
		String errorMessage = errorMsg.getText();
		return errorMessage;
	}
	
	public String getblankUsernameErrorMessage()
	{
		String errorMessage = blankUsernameErrorMsg.getText();
		return errorMessage;
	}
	
	public String getblankPasswordErrorMessage()
	{
		String errorMessage = blankPasswordErrorMsg.getText();
		return errorMessage;
	}
}
