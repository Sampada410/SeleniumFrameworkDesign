package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import SeleniumFrameworkDesign.PageObjects.LinkedInJobApplyPage;
import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;

public class LinkedInApplyTest extends BaseTest {

    @Test
    public void applyJobOnLinkedIn() throws IOException, InterruptedException {

        driver.get("https://www.linkedin.com/login");

        LinkedInJobApplyPage linkedInPage = new LinkedInJobApplyPage(driver);

        HashMap<String,String> data = getJsonDataToMap("LinkedInData.json");

        linkedInPage.login(data.get("email"), data.get("password"));
        linkedInPage.searchJob(data.get("jobTitle"));
        
//        linkedInPage.login("your_email@gmail.com", "your_password");

//        Thread.sleep(3000);
//
//        linkedInPage.searchJob("Automation Test Lead");

        Thread.sleep(3000);

        linkedInPage.clickFirstJobAndApply();

        Thread.sleep(3000);

        linkedInPage.completeApplication();
    }
}