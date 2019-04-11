package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.group5.projectplanner.app.ProjectPlanner;
import com.group5.projectplanner.app.Developer;

public class DeveloperTests {
	Developer developer;
	ProjectPlanner projectPlanner;
	
	public DeveloperTests(ProjectPlanner projectPlanner){
		this.projectPlanner = projectPlanner;
	}
	
	@Given("that a developer is registered in the project planner")
	public void thatADeveloperIsRegisteredInTheProjectPlanner() {
		developer = new Developer();
		developer.setID("abcd");
		assertTrue(developer.getID().equals("abcd"));
		projectPlanner.addDeveloper(developer);
		assertTrue(projectPlanner.checkDeveloperExist(developer));
		return;
	}

	@When("the developer adds a project with the name {string} and start year of {int}")
	public void theDeveloperAddsAProjectWithTheNameAndStartYearOf(String name, Integer year) {
		project = new Project();
		project.setName(name);
		project.setStartYear(year);
		projectPlanner.addProject(project);
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("the project with the name {string} and start year of {int} is added to the project planner")
	public void theProjectWithTheNameAndStartYearOfIsAddedToTheProjectPlanner(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(title, project.getName());
		assertEquals(author, project.getStartYear());
		assertTrue(projectPlanner.checkProjectExist(project));
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
