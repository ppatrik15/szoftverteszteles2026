package org.testing.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.testing.factory.WebDriverFactory;

public class Hooks {

    @Autowired
    private WebDriverFactory driverFactory;

    @Before
    public void setup(){
        driverFactory.getWebDriver().manage().deleteAllCookies();
    }

}
