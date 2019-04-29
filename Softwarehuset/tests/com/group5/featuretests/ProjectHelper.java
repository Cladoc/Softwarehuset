package com.group5.featuretests;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;
import com.group5.projectplanner.app.Project;

//Author: Casper (s163950)
public class ProjectHelper {
	private Project project;
	
	public Project getProject() throws Exception, FormattingException, NullObjectException {
		if (project == null) {
			project = exampleProject();
		}
		return this.project;
	}
	
	
	private Project exampleProject() throws Exception, FormattingException, NullObjectException {
		Project project = new Project();
		project.setName("Test");
		project.setStartYear("2020");
		return project;
	}
}
