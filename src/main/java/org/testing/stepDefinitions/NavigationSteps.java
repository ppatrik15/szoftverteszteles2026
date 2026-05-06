package org.testing.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.HomePage;
import org.testing.pageObjects.CommunityPage;

import static org.junit.Assert.assertTrue;

public class NavigationSteps {

    @Autowired
    private WebDriverFactory driverFactory;

    private WebDriver driver;
    private HomePage homePage;
    private CommunityPage communityPage;

    @When("I click the site logo")
    public void iClickLogo() {

        driver = driverFactory.getWebDriver();

        // Try to click from community page first
        if (communityPage != null) {
            communityPage.clickLogo();
        } else {
            homePage = new HomePage(driver);
            homePage.clickLogo();
        }
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToHomepage() {
        homePage = new HomePage(driver);

        assertTrue(
                "Homepage not loaded after clicking logo",
                homePage.isLoaded()
        );
    }
}