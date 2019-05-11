package com.group5.featuretests;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;
import com.group5.projectplanner.app.Project;
import com.group5.projectplanner.app.ProjectID;

//Author: Casper (s163950)
public class ProjectHelper {
	public Project project;
	
	public Project exampleProject() throws Exception, FormattingException, NullObjectException {
		Project project = new Project();
		ProjectID projectID = new ProjectID("Test");
		project.setID(projectID);
		project.setStartYear("2020");
		return project;
	}
	
	public Project exampleProjectTwo() throws Exception, FormattingException, NullObjectException {
		Project project = new Project();
		ProjectID projectID = new ProjectID("TestTwo");
		project.setID(projectID);
		project.setStartYear("2021");
		return project;
	}
}
