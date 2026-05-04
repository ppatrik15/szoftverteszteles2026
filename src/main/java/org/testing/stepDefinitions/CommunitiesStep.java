package org.testing.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.pageObjects.CommunitiesPage;

public class CommunitiesStep {

    @Autowired
    private CommunitiesPage communitiesPage;

    @Given("the Communities page is opened")
    public void theCommunitiesPageIsOpened() {
        communitiesPage.openPage();
    }

    @Then("at least one community card is visible on the page")
    public void atLeastOneCommunityCardIsVisibleOnThePage() {
        Assert.assertTrue("There are no visible community cards", communitiesPage.areCommunityCardsDisplayed());
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) throws InterruptedException {
        communitiesPage.fillSearchField(searchTerm);

        Thread.sleep(2000);
    }

    @Then("community cards related to the search should be displayed")
    public void communityCardsRelatedToTheSearchShouldBeDisplayed() {
        Assert.assertTrue("asd",  communitiesPage.areCommunityCardsDisplayed());
    }
}
