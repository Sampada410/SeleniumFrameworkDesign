package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumFrameworkDesign.PageObjects.JobSearch;
import SeleniumFrameworkDesign.PageObjects.ProfileEditPage;
import SeleniumFrameworkDesign.PageObjects.UpdateProfile;

public class ApplyOnNaukri extends BaseTest {

	@Test
	public void applyOnNaukri() throws IOException, InterruptedException
	{
		String[] recruiterAction= new String[2];
		String[] searchProfile = new String[2];
		
//		launchingApplication();
		landingPage.LoggingAppication("sampadasdesai@gmail.com", "Sampada@4");
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