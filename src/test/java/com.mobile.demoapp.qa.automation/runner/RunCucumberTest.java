package com.mobile.demoapp.qa.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features",
        glue= "com/mobile/demoapp/qa/automation/steps",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json","junit:target/cucumber-results.xml"},
        tags = "@tcid_1603986"
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

}
