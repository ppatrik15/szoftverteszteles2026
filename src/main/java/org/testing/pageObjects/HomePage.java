package org.testing.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    private By communityCards = By.cssSelector(".evnt-card-wrapper");
    private By logo = By.cssSelector("img[alt*='portal logo']");
    private By speakersFooterLink = By.xpath("//footer//a[contains(@href, '/speakers') or contains(text(), 'Speakers')]");
    private By footerTechnicalPlaceholder = By.xpath("//footer//*[contains(text(), 'qc6Crd6CXiTgTum')]");
    private By footerBlock = By.tagName("footer");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://wearecommunity.io/");
        acceptCookies();
    }

    private void acceptCookies() {
        try {
            org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(3));
            WebElement acceptButton = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptButton.click();
        } catch (Exception e) {
            // Cookie banner nem jelent meg vagy már elfogadtuk
        }
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

    public void clickSpeakersFooterLink() {
        WebElement footerLink = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(speakersFooterLink));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", footerLink);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            footerLink.click();
        } catch (Exception e) {
             ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", footerLink);
        }
    }

    public void scrollToFooter() {
        WebElement footer = driver.findElement(footerBlock);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
    }

    public boolean isTechnicalPlaceholderVisible() {
        return !driver.findElements(footerTechnicalPlaceholder).isEmpty();
    }
}