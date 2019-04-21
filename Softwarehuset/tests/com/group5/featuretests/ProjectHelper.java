package com.group5.featuretests;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.Project;

public class ProjectHelper {
	private Project project;
	
	public Project getProject() throws Exception, FormattingException {
		if (project == null) {
			project = exampleProject();
		}
		return this.project;
	}
	
	
	private Project exampleProject() throws Exception, FormattingException {
		Project project = new Project();
		project.setName("Test");
		project.setStartYear("2020");
		return project;
	}
}
