package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumFrameworkDesign.PageObjects.JobSearch;
import SeleniumFrameworkDesign.PageObjects.ProfileEditPage;
import SeleniumFrameworkDesign.PageObjects.UpdateProfile;

public class ApplyOnNaukri extends BaseTest {

	@Test(dataProvider = "getData")
	public void applyOnNaukri(HashMap<String,String> input) throws IOException, InterruptedException
	{
		try{
			String[] recruiterAction= new String[2];
		String[] searchProfile = new String[2];
		
//		launchingApplication();
		landingPage.LoggingAppication(input.get("email"), input.get("password"));
		TakeScreenshot("Login");
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
		jobSearchPage.goToJobSearch(input.get("job"), input.get("location"));
		jobSearchPage.filterApply("Engineering - Software & QA", "25-50 Lakhs", "Quality Assurance and Testing", input.get("location"));
		jobSearchPage.jobKeywordsToApply();
				
	}
	
	catch(Exception e) {
		TakeScreenshot("applyOnNaukri");
		throw e;
	}
}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = JsonToMap(System.getProperty("user.dir")+"/src/test/java/SeleniumFrameworkDesign/Data/NaukriData.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}