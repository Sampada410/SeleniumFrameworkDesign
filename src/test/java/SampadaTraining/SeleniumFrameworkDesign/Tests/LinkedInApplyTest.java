package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.PageObjects.LinkedInJobApplyPage;
import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;

public class LinkedInApplyTest extends BaseTest {

    @Test
    public void applyJobOnLinkedIn() throws IOException, InterruptedException {

        driver.get("https://www.linkedin.com/login");

        LinkedInJobApplyPage linkedInPage = new LinkedInJobApplyPage(driver);

        // Use secure method to store credentials (not hardcoded in real project)
        linkedInPage.login("your_email@gmail.com", "your_password");

        Thread.sleep(3000);

        linkedInPage.searchJob("Automation Test Lead");

        Thread.sleep(3000);

        linkedInPage.clickFirstJobAndApply();

        Thread.sleep(3000);

        linkedInPage.completeApplication();
    }
}