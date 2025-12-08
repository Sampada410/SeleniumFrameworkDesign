
package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestLinkedin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.linkedin.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("ml-3")).click();
		driver.findElement(By.id("username")).sendKeys("sampadasdesai@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Sampada@410");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//Job search
		
		driver.findElement(By.xpath("//li-icon[@type='job']")).click();
		driver.findElement(By.xpath("//input[@autocomplete='organization-title']")).sendKeys("Quality Assurance engineer");
		Thread.sleep(3000);
		driver.findElement(By.id("jobs-search-box-location-id-ember198")).sendKeys("Pune");
		
	}
}