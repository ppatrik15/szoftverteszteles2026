package org.testing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EventDetailsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Selector for the "Join Online" button
    private final By joinOnlineButton = By.xpath("//a[contains(., 'Join Online')]");

    public EventDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isJoinOnlineButtonActive() {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(joinOnlineButton));
            // An active button is simply visible and enabled (by default).
            // A disabled button would have a 'disabled' attribute. We check if it's enabled.
            return button.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}