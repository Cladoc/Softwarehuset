package com.group5.featuretests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "use_cases", 
	plugin = { "html:target/cucumber/wikipedia.html"}, 
	monochrome=true, 
	snippets = SnippetType.CAMELCASE, 
	glue = { "com.group5.featuretests"})

public class ProjTestRunner {
	
	}


