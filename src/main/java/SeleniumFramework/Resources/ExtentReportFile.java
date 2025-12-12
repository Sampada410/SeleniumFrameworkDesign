package SeleniumFramework.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportFile {

	public static ExtentReports config()
	{
		String path = System.getProperty("user.dir")+"//reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Job applications");
		reporter.config().setDocumentTitle("Naukri applications");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Sampada Jadhav");
		return extent;
		
	}
}
