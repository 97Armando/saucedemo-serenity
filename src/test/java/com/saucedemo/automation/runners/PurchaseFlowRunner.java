package com.saucedemo.automation.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/java/com/saucedemo/automation/features",
        glue = "com.saucedemo.automation.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@regression"
)
public class PurchaseFlowRunner {
}