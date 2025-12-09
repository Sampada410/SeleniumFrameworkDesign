package SampadaTraining.SeleniumFrameworkDesign.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SampadaTraining.SeleniumFrameworkDesign.TestComponents.BaseTest;


public class ErrorValidation extends BaseTest {

	@Test
	public void applyOnNaukri() throws IOException, InterruptedException
	{
		landingPage.LoggingAppication("sampadajsdesai@gmail.com", "Sampada@4");
		String msg = landingPage.getErrorMessage();
//		Assert.assertEquals("Invalid details. Please check the Email ID - Password combination.\\nIf you are a recruiter, please login from Employer login", msg);
		Assert.assertEquals("Invalid details. Please check the Email ID - Password combination.\nIf you are a recruiter, please login from Employer login", msg);
				
	}
}