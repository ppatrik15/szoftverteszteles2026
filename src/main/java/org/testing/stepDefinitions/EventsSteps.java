package org.testing.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.pageObjects.EventsPage;

public class EventsSteps {

    @Autowired
    private EventsPage eventsPage;

    @Given("the Events page is opened")
    public void theEventsPageIsOpened() {
        eventsPage.openPage();
    }

    @When("I filter the events by time {string}")
    public void iFilterTheEventsByTime(String time) {
        if ("Upcoming".equalsIgnoreCase(time)) {
            eventsPage.selectUpcomingTab();
        } else if ("Past".equalsIgnoreCase(time)) {
            eventsPage.selectPastTab();
        }
    }

    @Then("I should see only future events")
    public void iShouldSeeOnlyFutureEvents() {
        Assert.assertTrue("Future events are not displayed", eventsPage.areFutureEventsDisplayed());
    }

    @Then("I should see past events and recordings")
    public void iShouldSeePastEventsAndRecordings() {
        Assert.assertTrue("Past events are not displayed", eventsPage.arePastEventsDisplayed());
    }

    @When("I filter the events by language {string}")
    public void iFilterTheEventsByLanguage(String language) {
        eventsPage.filterByLanguage(language);
    }

    @Then("the event cards should display {string} language tags")
    public void theEventCardsShouldDisplayLanguageTags(String expectedTag) {
        Assert.assertTrue("Not all events have the expected language tag: " + expectedTag, eventsPage.allEventsHaveLanguage(expectedTag));
    }
}
