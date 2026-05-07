package org.testing.stepDefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.SpeakersPage;

import static org.junit.Assert.assertTrue;

public class SpeakersSteps {

    @Autowired
    private WebDriverFactory driverFactory;

    private WebDriver driver;
    private SpeakersPage speakersPage;

    @Then("the page should display the {string} error message")
    public void thePageShouldDisplayTheErrorMessage(String errorMessage) {
        driver = driverFactory.getWebDriver();
        speakersPage = new SpeakersPage(driver);
        assertTrue("The error message is not displayed.", speakersPage.isErrorMessageDisplayed());
    }
}