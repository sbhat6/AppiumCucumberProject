//This where Cucumber test execution starts. This has to have the details of both features & step definition packages.

package com.bbc.cucumbertestrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/com/bbc/cucumberfeaturefiles", glue = "com/bbc/cucumberstepdefinitions")

public class TestRunner extends AbstractTestNGCucumberTests {

}