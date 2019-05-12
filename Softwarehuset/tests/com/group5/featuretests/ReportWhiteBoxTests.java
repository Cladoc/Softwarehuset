package com.group5.featuretests;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.List;


import com.group5.projectplanner.app.*;
//Error message step is used from developerTests
public class ReportWhiteBoxTests {
	ProjectPlanner projectPlanner;
	ErrorMessageHolder errorMessageHolder;
	Developer developer1;
	Developer developer2;
	DeveloperID developerID1;
	DeveloperID developerID2;
	String testName1;
	String testName2;
	Project project1;
	Project project2;
	ProjectID projectID1;
	ProjectID projectID2;
	String projectName1;
	List<Project> listState1;
	List<Project> listState2;
	boolean devRegistered = false;
	
	public ReportWhiteBoxTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
	}
	
	//DeveloperRepository.addDeveloper------------------------------------
	//Test1
	@Given("a developer exists with an ID")
	public void aDeveloperExistsWithAnID() {
		developer1 = new Developer();
		developerID1 = new DeveloperID();
		testName1 = "Test";
		developerID1.setName(testName1);
		developer1.setID(developerID1);
		assertTrue(developer1 != null);
		assertTrue(developerID1 != null);
		assertTrue(developerID1.getName().equals(testName1));
		assertTrue(developer1.getDeveloperID() == developerID1);
	}
	
	@Given("the project planner has no developer registered with the same ID")
	public void theProjectPlannerHasNoDeveloperRegisteredWithTheSameID() {
	    assertFalse(projectPlanner.checkDeveloperExist(developerID1));
	}
	
	@When("developer is registered in the project planner")
	public void developerIsRegisteredInTheProjectPlanner() throws OperationNotAllowedException {
		projectPlanner.addDeveloper(developer1);
	}
	
	@Then("the developer is registered in the project planner successfully")
	public void theDeveloperIsRegisteredInTheProjectPlannerSuccessfully() {
	    assertTrue(projectPlanner.checkDeveloperExist(developerID1));
	}
	
	//Test2
	@Given("another developer exists with an ID of the same name")
	public void anotherDeveloperExistsWithAnIDOfTheSameName() {
		developer2 = new Developer();
		developerID2 = new DeveloperID();
		testName2 = "Test";
		developerID2.setName(testName2);
		developer2.setID(developerID2);
		assertTrue(developer2 != null);
		assertTrue(developerID2 != null);
		assertTrue(developerID2.getName().equals(testName2));
		assertTrue(developer2.getDeveloperID() == developerID2);
		assertTrue(developer1.getName().equals(developer2.getName()));
	}
	
	@Given("the second developer is registered in the project planner")
	public void theSecondDeveloperIsRegisteredInTheProjectPlanner() throws OperationNotAllowedException{
		projectPlanner.addDeveloper(developer2);
	    assertTrue(projectPlanner.checkDeveloperExist(developerID2));
	}
	
	@When("the first developer is added to the project planner")
	public void theFirstDeveloperIsAddedToTheProjectPlanner() throws OperationNotAllowedException{
	    try{
	    	projectPlanner.addDeveloper(developer1);
	    }catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	//ProjectRepository.addProject
	//Test1
	@Given("the developer is in the project planner")
	public void theDeveloperIsInTheProjectPlanner() throws OperationNotAllowedException {
	    projectPlanner.addDeveloper(developer1);
	    assertTrue(projectPlanner.checkDeveloperExist(developerID1));
	}
	
	@Given("a project exists with an ID")
	public void aProjectExistsWithAnID() {
		project1 = new Project();
		projectID1 = new ProjectID();
		projectName1 = "Test";
		projectID1.setName(projectName1);
		project1.setID(projectID1);
		assertTrue(project1 != null);
		assertTrue(projectID1 != null);
		assertTrue(projectID1.getName().equals(projectName1));
		assertTrue(project1.getID()==projectID1);
	}
	
	@Given("the project is not registered in the project planner")
	public void theProjectIsNotRegisteredInTheProjectPlanner() {
	    assertFalse(projectPlanner.checkProjectExist(projectID1));
	}
	
	@When("the project is added to the project planner")
	public void theProjectIsAddedToTheProjectPlanner() throws OperationNotAllowedException {
	    projectPlanner.addProject(project1, developerID1);
	}
	
	@Then("the project is added to the project planner successfully")
	public void theProjectIsAddedToTheProjectPlannerSuccessfully() {
	    assertTrue(projectPlanner.checkProjectExist(projectID1));
	}
	
	@Given("a second project exists with the same ID")
	public void aSecondProjectExistsWithTheSameID() {
		project2 = new Project();
		projectID2 = new ProjectID();
		projectName1 = "Test";
		projectID2.setName(projectName1);
		project2.setID(projectID2);
		assertTrue(project2 != null);
		assertTrue(projectID2 != null);
		assertTrue(projectID2.getName().equals(projectName1));
		assertTrue(project2.getID()==projectID2);
	}
	
	@Then("the project repository contains {int} project")
	public void theProjectRepositoryContainsProject(Integer count) {
	    listState1 = projectPlanner.getProjects();
	    assertTrue(listState1.size() == 1);
	}
	
	@Given("the second project is in the project planner")
	public void theSecondProjectIsInTheProjectPlanner() throws OperationNotAllowedException {
	    projectPlanner.addProject(project2, developerID1);
	    assertTrue(projectPlanner.checkProjectExist(projectID2));
	}
	
	@When("the first project is added to the project planner")
	public void theFirstProjectIsAddedToTheProjectPlanner() {
	    try{
	    	projectPlanner.addProject(project1, developerID1);
	    }catch (OperationNotAllowedException e){
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	@Then("the project repository is unchanged")
	public void theProjectRepositoryIsUnchanged() {
		listState2 = projectPlanner.getProjects();
		assertTrue(listState1 == listState2);
		assertTrue(listState1.size() == listState2.size());
		for(int i = 0; i < listState1.size(); i++){
			assertTrue(listState1.get(i).getID().equals(listState2.get(i).getID()));
			assertTrue(listState1.get(i).getID().getName().equals(listState2.get(i).getID().getName()));
			assertTrue(listState1.get(i).getID().getSerialNumber() == listState2.get(i).getID().getSerialNumber());
			assertTrue(listState1.get(i).getID().getYear() == listState2.get(i).getID().getYear());
			assertTrue(listState1.get(i).getStartYear() == listState2.get(i).getStartYear());
			assertTrue(listState1.get(i).getStartWeek() == listState2.get(i).getStartWeek());
			assertTrue(listState1.get(i).getEndYear() == listState2.get(i).getEndYear());
			assertTrue(listState1.get(i).getEndWeek() == listState2.get(i).getEndWeek());
		}
	}
	
	//DeveloperRepository.CheckDeveloperExist()
	//Test1
	@When("a developer checks if the developer is registered in the project planner")
	public void aDeveloperChecksIfTheDeveloperIsRegisteredInTheProjectPlanner() {
		devRegistered = projectPlanner.checkDeveloperExist(developerID1);
	}

	@Then("it is confirmed that the developer is registered in the project planner")
	public void itIsConfirmedThatTheDeveloperIsRegisteredInTheProjectPlanner() {
	    assertTrue(devRegistered);
	}
	
	//Test2
	@Then("it is refuted that the developer is registered in the project planner")
	public void itIsRefutedThatTheDeveloperIsRegisteredInTheProjectPlanner() {
		assertFalse(devRegistered);
	}
	
	//Test3
	
	@Given("a second developer exists with a different ID from the first developer")
	public void aSecondDeveloperExistsWithADifferentIDFromTheFirstDeveloper() {
		developer2 = new Developer();
		developerID2 = new DeveloperID();
		testName2 = "Test2";
		developerID2.setName(testName2);
		developer2.setID(developerID2);
		assertTrue(developer2 != null);
		assertTrue(developerID2 != null);
		assertTrue(developerID2.getName().equals(testName2));
		assertTrue(developer2.getDeveloperID() == developerID2);
		assertFalse(developer2.getName().equals(developer1.getName()));
	}
	
	
}
