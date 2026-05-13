package org.testing.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public WebDriver webDriver;

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = setupWebDriver();
        }
        return webDriver;
    }

    private WebDriver setupWebDriver() {
        var options = new ChromeOptions()
                .addArguments("--no-sandbox")
                .addArguments("--remote-allow-origins")
                .addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        }
    }
}
