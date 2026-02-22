package SeleniumFrameworkDesign.PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import SeleniumFramework.AbstractComponents.AbstractComponents;

public class LinkedInJobApplyPage extends AbstractComponents {

    WebDriver driver;

    public LinkedInJobApplyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(id = "username")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInBtn;

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    WebElement jobSearchBox;

    @FindBy(xpath = "//button[contains(@aria-label,'Search')]")
    WebElement searchButton;

    @FindBy(xpath = "//button[contains(@class,'jobs-apply-button')]")
    WebElement easyApplyButton;

    @FindBy(xpath = "//button[@aria-label='Submit application']")
    WebElement submitApplicationBtn;

    @FindBy(xpath = "//button[@aria-label='Continue to next step']")
    WebElement nextButton;

    // Methods

    public void login(String userEmail, String userPassword) {
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        signInBtn.click();
    }

    public void searchJob(String jobTitle) {
        jobSearchBox.sendKeys(jobTitle);
        searchButton.click();
    }

    public void clickFirstJobAndApply() {
    	waitForElement(easyApplyButton);
//        wait.until(ExpectedConditions.elementToBeClickable(easyApplyButton));
        easyApplyButton.click();
    }

    public void completeApplication() {

        while (true) {
            try {
                if (submitApplicationBtn.isDisplayed()) {
                    submitApplicationBtn.click();
                    break;
                } else {
                    nextButton.click();
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}