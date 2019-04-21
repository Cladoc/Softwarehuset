package com.group5.featuretests;
import com.group5.projectplanner.app.ProjectPlanner;
import com.group5.projectplanner.app.Developer;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;
import com.group5.projectplanner.app.Project;
import com.group5.projectplanner.app.ProjectActivity;
import com.group5.projectplanner.app.OperationNotAllowedException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LeaderTests {
	ProjectPlanner projectPlanner;
	ErrorMessageHolder errorMessageHolder;
	ProjectHelper projectHelper;
	Developer developer;
	Project project;
	ProjectActivity projectActivity;
	
	
	public LeaderTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder, ProjectHelper projectHelper){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this. projectHelper = projectHelper;
	}
	
	@Given("a developer is project leader on a project registered in the project planner")
	public void aDeveloperIsProjectLeaderOnAProjectRegisteredInTheProjectPlanner() throws Exception, FormattingException, OperationNotAllowedException {
	    developer = new Developer();
	    developer.setID("abcd");
	    project = new Project();
	    project.setName("Test");
	    project.setStartYear("2020");
	    projectPlanner.addDeveloper(developer);
	    projectPlanner.addProject(project, developer);
	    projectPlanner.setProjectLeader(project, developer);
	    assertTrue(projectPlanner.isProjectLeader(project, developer));
	}
	
	@When("the project leader adds an activity with the name {string}")
	public void theProjectLeaderAddsAnActivityWithTheName(String name) throws NullObjectException, OperationNotAllowedException {
	    projectActivity = new ProjectActivity();
	    projectActivity.setName(name);
	    assertTrue(projectActivity.getName().equals(name));
	    projectPlanner.addActivity(projectActivity, project, developer);
	}

	@Then("the activity with name {string} is added to the project")
	public void theActivityWithNameIsAddedToTheProject(String string) throws NullObjectException {
	    assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}
	
	@Given("an activity is registered with the name {string}")
	public void anActivityIsRegisteredWithTheName(String name) throws NullObjectException, OperationNotAllowedException {
	    projectActivity = new ProjectActivity();
	    projectActivity.setName(name);
	    projectPlanner.addActivity(projectActivity, project, developer);
	    assertTrue(projectPlanner.checkActivityExists(projectActivity, project));
	}

	@When("the project leader adds an activity with the name {string} again")
	public void theProjectLeaderAddsAnActivityWithTheNameAgain(String name) throws NullObjectException, OperationNotAllowedException{
	    ProjectActivity projectActivity2 = new ProjectActivity();
	    projectActivity2.setName(name);
	    try{
	    	projectPlanner.addActivity(projectActivity2, project, developer);
	    }catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	    
	}
	
	@Given("that he is not project leader on the project")
	public void thatHeIsNotProjectLeaderOnTheProject(){
	    assertFalse(projectPlanner.isProjectLeader(project, developer));
	}
	
}
