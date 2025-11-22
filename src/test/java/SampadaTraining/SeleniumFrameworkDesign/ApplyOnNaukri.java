package SampadaTraining.SeleniumFrameworkDesign;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumFrameworkDesign.PageObjects.JobSearch;
import SeleniumFrameworkDesign.PageObjects.LandingPage;
import SeleniumFrameworkDesign.PageObjects.ProfileEditPage;
import SeleniumFrameworkDesign.PageObjects.UpdateProfile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyOnNaukri {

	public static void main(String[] args) throws InterruptedException {
		
		String[] recruiterAction= new String[2];
		String[] searchProfile = new String[2];
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToNaukri();
		landingPage.LoggingAppication("sampadasdesai@gmail.com", "Sampada@4");
		
//		driver.manage().window().maximize();
		
		//Right side profile pop-up page 
		UpdateProfile updateProfile = new UpdateProfile(driver);
		updateProfile.goToPerformancePage();
		recruiterAction = updateProfile.recruiterActionCount();
		searchProfile = updateProfile.searchAppearanceCount();
		updateProfile.closePerformancePage();
		
		//Main user profile editing page
		ProfileEditPage editProfile = new ProfileEditPage(driver);
		editProfile.userProfilePage();
		editProfile.editProfile();
		editProfile.resumeHeadlineEdit();
		editProfile.saveButton();

		//Job search and job applying process
		JobSearch jobSearchPage = new JobSearch(driver);
		jobSearchPage.goToHomePage();
		jobSearchPage.goToRecommendedJob();
		jobSearchPage.goToJobSearch("Test manager", "Pune");
		jobSearchPage.filterApply("Engineering - Software & QA", "25-50 Lakhs", "Quality Assurance and Testing", "Pune");
		jobSearchPage.jobKeywordsToApply();
				
	}
}