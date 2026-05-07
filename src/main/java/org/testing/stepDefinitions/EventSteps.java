package org.testing.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.EventDetailsPage;

import static org.junit.Assert.assertTrue;

public class EventSteps {

    @Autowired
    private WebDriverFactory driverFactory;

    private WebDriver driver;
    private EventDetailsPage eventDetailsPage;

    @Given("the user is viewing an upcoming online event")
    public void theUserIsViewingAnUpcomingOnlineEvent() {
        driver = driverFactory.getWebDriver();
        // For this test, we navigate to a specific event that is known to be in the future.
        // This URL might need to be updated if the event passes.
        driver.get("https://wearecommunity.io/events/istqb-foundation-exam-preparation-in-english-40h-2024-10-14");
    }

    @Then("the {string} button should be active")
    public void theButtonShouldBeActive(String buttonName) {
        eventDetailsPage = new EventDetailsPage(driver);
        assertTrue("The 'Join Online' button is not active, but it should be.", eventDetailsPage.isJoinOnlineButtonActive());
    }
}