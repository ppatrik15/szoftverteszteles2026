package org.testing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By communityCards = By.cssSelector(".evnt-card-wrapper");
    private By logo = By.cssSelector("img[alt*='portal logo']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://wearecommunity.io/");
    }

    public boolean isLoaded() {
        return driver.findElements(communityCards).size() > 0;
    }

    public void clickFirstCommunity() {
        driver.findElements(communityCards).get(0).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public boolean hasCommunityCards() {
        return driver.findElements(communityCards).size() > 0;
    }
}