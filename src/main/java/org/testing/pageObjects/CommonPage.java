package org.testing.pageObjects;

import org.testing.factory.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
    public CommonPage(final WebDriverFactory factory) {
        PageFactory.initElements(factory.getWebDriver(), this);
    }
}
