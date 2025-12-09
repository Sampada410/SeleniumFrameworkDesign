package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;


public class ErrorValidationTest extends BaseTest {

	@Test(priority = 2)
	public void ErrorLoggingPage() throws IOException, InterruptedException
	{
		landingPage.LoggingAppication("sampadasjdesai@gmail.com", "Sampada@4");
		String msg = landingPage.getErrorMessage();
		TakeScreenshot("ErrorLoggingPage");
		Assert.assertEquals("Invalid details. Please check the Email ID - Password combination.\nIf you are a recruiter, please login from Employer login", msg);
				
	}
	
	@Test(priority = 1)
	public void ErrorWithBlankLogging() throws IOException
	{
		landingPage.LoggingAppication("", "");
		TakeScreenshot("ErrorWithBlankLogging");
		String uMsg = landingPage.getblankUsernameErrorMessage();
		String pMsg = landingPage.getblankPasswordErrorMessage();
		Assert.assertEquals("Please enter your Email ID / Username", uMsg);
		Assert.assertEquals("Please enter your Password", pMsg);
	}
}