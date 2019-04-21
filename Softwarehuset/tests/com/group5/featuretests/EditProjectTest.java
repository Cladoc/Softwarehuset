package com.group5.featuretests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.group5.projectplanner.app.*;

public class EditProjectTest {
	ProjectPlanner projectPlanner;
	Developer developer;
	Project project;
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
