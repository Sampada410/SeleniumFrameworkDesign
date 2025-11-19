package SeleniumFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	
	//waits
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
}
