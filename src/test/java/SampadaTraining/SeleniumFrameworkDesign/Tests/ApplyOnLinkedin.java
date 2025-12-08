
package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumFrameworkDesign.PageObjects.JobSearchLinkedin;
import SeleniumFrameworkDesign.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ApplyOnLinkedin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToLinkedin();
		landingPage.LoggingAppicationLN("sampadajadhav0410@gmail.com", "Sampada@410");
		
		
		//job search
		
		JobSearchLinkedin jobSearchLinkedin = new JobSearchLinkedin(driver);
		jobSearchLinkedin.goToJobpage();
		jobSearchLinkedin.jobsearch("Test manager", "United Kingdom");
		jobSearchLinkedin.showAllFilters();
		jobSearchLinkedin.enableEasyApply();
		

}
}