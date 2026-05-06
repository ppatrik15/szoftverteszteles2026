package org.testing.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.HomePage;

import static org.junit.Assert.assertTrue;

public class HomeSteps {

    @Autowired
    private WebDriverFactory driverFactory;

    private WebDriver driver;
    private HomePage homePage;

    @Given("I am on the homepage")
    public void iAmOnHomepage() {
        driver = driverFactory.getWebDriver();

        homePage = new HomePage(driver);
        homePage.open();
    }

    @Then("I should see a list of community cards")
    public void iShouldSeeCommunityCards() {
        assertTrue("Community cards not visible", homePage.hasCommunityCards());
    }
}