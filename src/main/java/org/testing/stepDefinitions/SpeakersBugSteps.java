package org.testing.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.HomePage;
import org.testing.pageObjects.SpeakersPage;

public class SpeakersBugSteps {

    @Autowired
    private WebDriverFactory driverFactory;

    @Autowired
    private SpeakersPage speakersPage;

    private HomePage homePage;

    @When("I click on the {string} link in the footer")
    public void iClickOnTheLinkInTheFooter(String linkText) {
        WebDriver driver = driverFactory.getWebDriver();
        homePage = new HomePage(driver);
        
        if ("Speakers".equalsIgnoreCase(linkText)) {
            homePage.clickSpeakersFooterLink();
        }
    }

        @Then("a full grid of speaker cards should be displayed")
    public void aFullGridOfSpeakerCardsShouldBeDisplayed() {
        Assert.assertTrue("Speaker cards are not displayed", speakersPage.areSpeakerCardsDisplayed());
    }

    @Then("I should not see the {string} error message")
    public void iShouldNotSeeTheErrorMessage(String errorMessage) {
        Assert.assertFalse("The error message '" + errorMessage + "' is displayed!", speakersPage.isErrorMessageDisplayed());
    }
}
