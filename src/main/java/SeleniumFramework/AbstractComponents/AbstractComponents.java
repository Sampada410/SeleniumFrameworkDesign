package SeleniumFramework.AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	String url = "https://www.naukri.com/mnjuser/homepage";
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	
	
	//waits
	public void waitForByElement(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForElement(WebElement webelement) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void waitForStaleness(WebElement webelement) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(webelement));
	}
	
	public void sleepDuration(int duration) throws InterruptedException {
		
		Thread.sleep(duration);
		
	}
	
	public void goToHomePage()
	{
		driver.get(url);
	}
	
	public void scrollBy(WebElement webelement) {
		Actions actions = new Actions(driver);
//		actions.scrollByAmount(x,y).perform();
		actions.scrollToElement(webelement).perform();
		actions.moveToElement(webelement);
	}

	
	public String TakeScreenshot(String testname, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String path = System.getProperty("user.dir")+"/screenshot/"+ testname +"_"+ timestamp +".png";
		
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}


}
