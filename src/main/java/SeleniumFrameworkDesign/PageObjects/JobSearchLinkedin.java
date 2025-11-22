package SeleniumFrameworkDesign.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class JobSearchLinkedin extends AbstractComponents {

	WebDriver driver;
	
	public JobSearchLinkedin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[@title='Jobs']")
	WebElement jobsLink;
	
	@FindBy(xpath = "//input[@placeholder='Title, skill or Company']")
	WebElement jobTitle;
	
	@FindBy(xpath = "//input[@placeholder='City, state, or zip code']")
	WebElement location;
	
	@FindBy(xpath = "//button[text()='All filters']")
	WebElement allFilterButton;
	
	@FindBy(xpath = "//label[contains(.,'Easy Apply')]/input")
	WebElement easyApplyText;
	
	public void goToJobpage() {
		jobsLink.click();
	}
	
	public void jobsearch(String jobKeyword, String jobLocation) {
		
		jobTitle.sendKeys(jobKeyword);
		location.sendKeys(jobLocation, Keys.ENTER);
	}
	
	public void showAllFilters() {
		allFilterButton.click();
	}
	
	public void enableEasyApply() throws InterruptedException {

//		WebElement filterScrollArea1 = driver.findElement(By.cssSelector("div.artdeco-modal__content"));
//
//		WebElement targetFilter = driver.findElement(By.xpath("//h3[text()='Easy Apply']"));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		// Scroll inside popup until filter is visible
//		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", filterScrollArea1);
//		Thread.sleep(500);
//
//		// Scroll element into view
//		js.executeScript("arguments[0].scrollIntoView(true);", targetFilter);
		
		
		
		
		
//		scrollBy(easyApplyText);
		List<WebElement> filterNames=driver.findElements(By.cssSelector(".text-heading-large"));
		
		for(WebElement filterName: filterNames) {
			String filterText = filterName.getText().toLowerCase().trim();
			if(filterText.equalsIgnoreCase("easy apply")) {
				WebElement filterScrollArea1 = driver.findElement(By.cssSelector("div.artdeco-modal__content"));
				WebElement targetFilter = driver.findElement(By.xpath("//h3[text()='Easy Apply']"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
				// Scroll inside popup until filter is visible
				js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", filterScrollArea1);
				Thread.sleep(500);
				
				// Scroll element into view
				js.executeScript("arguments[0].scrollIntoView(true);", targetFilter);
				Thread.sleep(5000);
				if (!easyApplyText.isSelected()) {
					easyApplyText.click();
			}
		}
	}
	}
}
