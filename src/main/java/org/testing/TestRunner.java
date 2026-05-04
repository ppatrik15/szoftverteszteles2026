package org.testing;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",

        glue = "org.testing",

        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html"
        }
)
public class TestRunner {
}