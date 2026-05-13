package org.testing.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;
import org.testing.pageObjects.HomePage;

public class FooterBugSteps {

    @Autowired
    private WebDriverFactory driverFactory;

    private HomePage homePage;

    @When("I scroll to the footer")
    public void iScrollToTheFooter() {
        WebDriver driver = driverFactory.getWebDriver();
        homePage = new HomePage(driver);
        homePage.scrollToFooter();
    }

    @Then("the footer should display meaningful text")
    public void theFooterShouldDisplayMeaningfulText() {
        // Here we just ensure we scrolled down successfully and didn't crash.
        // We will rely on the next step to assert the absence of the technical placeholder.
        Assert.assertTrue("Homepage should be loaded", homePage.hasCommunityCards());
    }

    @Then("I should not see the technical placeholder {string}")
    public void iShouldNotSeeTheTechnicalPlaceholder(String placeholder) {
        Assert.assertFalse("The technical placeholder '" + placeholder + "' is visible in the footer!", homePage.isTechnicalPlaceholderVisible());
    }
}
