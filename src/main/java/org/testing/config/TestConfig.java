package org.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testing.factory.WebDriverFactory;

@Configuration
@ComponentScan("org.testing")
public class TestConfig {
    @Bean(destroyMethod = "closeWebDriver")
    public WebDriverFactory getWebDriverFactory() {
        return new WebDriverFactory();
    }
}
