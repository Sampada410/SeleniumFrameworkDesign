package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumFrameworkDesign.PageObjects.JobSearch;
import SeleniumFrameworkDesign.PageObjects.ProfileEditPage;
import SeleniumFrameworkDesign.PageObjects.UpdateProfile;

public class ApplyOnNaukri extends BaseTest {

	@Test(dataProvider = "getData")
	public void applyOnNaukri(String email, String password, String job, String location) throws IOException, InterruptedException
	{
		try{
			String[] recruiterAction= new String[2];
		String[] searchProfile = new String[2];
		
//		launchingApplication();
		landingPage.LoggingAppication(email, password);
		//Right side profile pop-up page 
		UpdateProfile updateProfile = new UpdateProfile(driver);
		updateProfile.goToPerformancePage();
		recruiterAction = updateProfile.recruiterActionCount();
		searchProfile = updateProfile.searchAppearanceCount();
		updateProfile.closePerformancePage();
		
		//Main user profile editing page
		ProfileEditPage editProfile = new ProfileEditPage(driver);
		editProfile.userProfilePage();
//		editProfile.editProfile();
//		editProfile.resumeHeadlineEdit();
//		editProfile.saveButton();

		//Job search and job applying process
		JobSearch jobSearchPage = new JobSearch(driver);
		jobSearchPage.goToHomePage();
		jobSearchPage.goToRecommendedJob();
		jobSearchPage.goToJobSearch(job, location);
		jobSearchPage.filterApply("Engineering - Software & QA", "25-50 Lakhs", "Quality Assurance and Testing", location);
		jobSearchPage.jobKeywordsToApply();
				
	}
	
	catch(Exception e) {
		TakeScreenshot("applyOnNaukri");
		throw e;
	}
}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"sampadasdesai@gmail.com", "Sampada@4", "Quality assurance", "Pune"},{"santosh.n.desai@gmail.com", "Santosh26", "ETL test manager", "Pune"}};
	}
	
}