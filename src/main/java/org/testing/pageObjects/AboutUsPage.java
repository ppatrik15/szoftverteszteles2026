package org.testing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.factory.WebDriverFactory;

import java.time.Duration;

public class AboutUsPage {

    private By instagram = By.cssSelector("a[href*='instagram']");
    private By email = By.cssSelector("a[href*='mailto']");

    private static final String ABOUT_US_PAGE_URL = "https://wearecommunity.io/about-us";
    public final WebDriver driver;

    private final WebDriverWait wait;

    public AboutUsPage(final WebDriverFactory factory) {
        this.driver = factory.getWebDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean hasInstagramIcon() {
        return !driver.findElements(instagram).isEmpty();
    }

    public boolean hasEmailIcon() {
        return !driver.findElements(email).isEmpty();
    }

    public void clickInstagram() {
        WebElement instaIcon = wait.until(ExpectedConditions.presenceOfElementLocated(instagram));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", instaIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", instaIcon);
    }

    public void clickEmail() {
        WebElement emailIcon = wait.until(ExpectedConditions.presenceOfElementLocated(email));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", emailIcon);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailIcon);
    }

    public void open() {
        driver.get(ABOUT_US_PAGE_URL);
    }
}