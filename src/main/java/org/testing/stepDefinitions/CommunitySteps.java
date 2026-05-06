package org.testing.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.HomePage;
import org.testing.pageObjects.CommunityPage;

import static org.junit.Assert.*;

public class CommunitySteps {

    @Autowired
    private WebDriverFactory driverFactory;

    private WebDriver driver;
    private HomePage homePage;
    private CommunityPage communityPage;

    @When("I click on the first community card")
    public void iClickFirstCommunity() {
        driver = driverFactory.getWebDriver();

        homePage = new HomePage(driver);
        homePage.clickFirstCommunity();

        communityPage = new CommunityPage(driver);
    }

    @Then("I should be redirected to the community detail page")
    public void iShouldBeOnCommunityPage() {
        assertTrue(
                "Community page not loaded",
                communityPage.isLoaded()
        );
    }

    @Then("I should see the community title")
    public void iShouldSeeCommunityTitle() {
        String title = communityPage.getTitle();

        assertNotNull(title);
        assertFalse(title.trim().isEmpty());
    }
}