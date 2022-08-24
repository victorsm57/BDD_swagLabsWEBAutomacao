package com.saucedemo.módulos;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features\\login.feature", glue = {"login"},
        monochrome = true, plugin = {"pretty", "json.target/JSONReports"})
public class TestRunner {
}
