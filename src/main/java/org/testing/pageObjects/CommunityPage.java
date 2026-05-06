package org.testing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommunityPage {

    private WebDriver driver;

    private By title = By.xpath("//h1");
    private By logo = By.cssSelector("img[alt*='portal logo']");

    public CommunityPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return driver.findElements(title).size() > 0;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }
}