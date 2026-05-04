package org.testing.pageObjects;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;
import org.testing.factory.WebDriverFactory;

@Component
public class CommunitiesPage extends CommonPage {
    public CommunitiesPage(final WebDriverFactory factory) {
        super(factory);
    }

    private static final String HOME_PAGE_URL = "https://wearecommunity.io/communities";
}
