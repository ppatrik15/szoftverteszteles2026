package org.testing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testing.factory.WebDriverFactory;

import java.util.List;

@Component
@Scope("cucumber-glue")
public class CommunitiesPage extends CommonPage {

    private static final String COMMUNITIES_PAGE_URL = "https://wearecommunity.io/communities";
    private final WebDriver driver;

    public CommunitiesPage(final WebDriverFactory factory) {
        super(factory);
        this.driver = factory.getWebDriver();
    }


    @FindBy(xpath = "//input[@placeholder='Search by Title or Tags']")
    private WebElement searchField;

    @FindBy(className = "evnt-community-card")
    private List<WebElement> communityCards;


    public void openPage() {
        driver.get(COMMUNITIES_PAGE_URL);
    }

    public void fillSearchField(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public boolean areCommunityCardsDisplayed() {
        if (communityCards == null || communityCards.isEmpty()) {
            return false;
        }
        return communityCards.get(0).isDisplayed();
    }
}
