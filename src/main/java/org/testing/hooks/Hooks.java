package org.testing.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;

public class Hooks {

    @Autowired
    private WebDriverFactory driverFactory;

    @Before
    public void setup(){
        driverFactory.getWebDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        driverFactory.closeWebDriver();
    }
}
