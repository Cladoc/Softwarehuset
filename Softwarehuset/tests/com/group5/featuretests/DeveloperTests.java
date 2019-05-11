package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertFalse;
import com.group5.projectplanner.app.*;

public class DeveloperTests {
	ProjectPlanner projectPlanner;
	Developer developer;
	Activity projectActivity;
	Project project;
	Project project2; 
	ProjectID projectID;
	ProjectID projectID2; 
	DeveloperID developerID;
	List<ProjectID> projectIDs;
	ActivityID activityID;
	ErrorMessageHolder errorMessageHolder;
	ProjectHelper projectHelper;
	DeveloperHelper developerHelper;

	public DeveloperTests(ProjectPlanner projectPlanner, ErrorMessageHolder errorMessageHolder, ProjectHelper projectHelper, DeveloperHelper developerHelper){
		this.projectPlanner = projectPlanner;
		this.errorMessageHolder = errorMessageHolder;
		this.projectHelper = projectHelper;
		this.developerHelper = developerHelper;
	}

	



}
