package com.group5.featuretests;

//import cucumber.api.CucumberOptions;
//import cucumber.api.SnippetType;
//import cucumber.api.junit.Cucumber;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;
import java.util.List;
import static org.hamcrest.CoreMatchers.*; // g�r det uligt at bruge equalTo metode
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


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

public class TestRunner {
	
	
	@Given("that a developer is registered in the project planner")
	public void thatADeveloperIsRegisteredInTheProjectPlanner() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("the developer adds a project with the name {string} and start year of {int}")
	public void theDeveloperAddsAProjectWithTheNameAndStartYearOf(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the project with the name {string} and start year of {int} is added to the project planner")
	public void theProjectWithTheNameAndStartYearOfIsAddedToTheProjectPlanner(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("the developer adds a project with the name {string} and start year of {string}")
	public void theDeveloperAddsAProjectWithTheNameAndStartYearOf(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("he gets the error message {string}")
	public void heGetsTheErrorMessage(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("a project is registered with the name {string} When the developer adds a project with the name {string} and start year of {int}")
	public void aProjectIsRegisteredWithTheNameWhenTheDeveloperAddsAProjectWithTheNameAndStartYearOf(String string, String string2, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("that a developer is not registered in the project planner")
	public void thatADeveloperIsNotRegisteredInTheProjectPlanner() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("he gets an error message of {string}")
	public void heGetsAnErrorMessageOf(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


}


