package org.testing.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

@Component
public class WebDriverFactory {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = setupWebDriver();
        }
        return webDriver;
    }

    private WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
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
