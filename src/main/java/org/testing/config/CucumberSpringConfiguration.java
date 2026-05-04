package org.testing.config;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@CucumberOptions(glue = "deik.pti")
@ContextConfiguration(classes = TestConfig.class)
public class CucumberSpringConfiguration {
}
