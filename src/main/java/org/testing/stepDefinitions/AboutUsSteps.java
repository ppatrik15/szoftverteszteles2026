package org.testing.stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.pageObjects.AboutUsPage;
import org.testing.factory.WebDriverFactory;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class AboutUsSteps {

    private AboutUsPage aboutUsPage;

    public AboutUsSteps(WebDriverFactory factory) {
        this.aboutUsPage = new AboutUsPage(factory);
    }

    @Given("the About Us page is opened")
    public void theAboutUsPageIsOpened() {
        aboutUsPage.open();
    }

    @When("the Instagram icon is visible on the page")
    public void theInstagramIconIsVisibleOnThePage() {
        assertTrue(aboutUsPage.hasInstagramIcon());
    }

    @And("the Email icon is visible on the page")
    public void theEmailIconIsVisibleOnThePage() {
        assertTrue(aboutUsPage.hasEmailIcon());
    }

    @Then("I click on the Instagram icon")
    public void iClickOnTheInstagramIcon() {
        aboutUsPage.clickInstagram();
    }

    @Then("I should be on instagram")
    public void iShouldBeOnInstagram() {
        WebDriverWait wait = new WebDriverWait(aboutUsPage.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for (String windowHandle : aboutUsPage.driver.getWindowHandles()) {
            aboutUsPage.driver.switchTo().window(windowHandle);
        }

        wait.until(ExpectedConditions.urlContains("instagram"));
        assertTrue(aboutUsPage.driver.getCurrentUrl().contains("instagram"));
    }
}