package com.group5.featuretests;

import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.Developer;
import com.group5.projectplanner.app.DeveloperID;

public class DeveloperHelper {

//Author: Casper (s163950)
private Developer developer;

	
	public Developer getDeveloper() throws Exception, FormattingException {
		if (developer == null) {
			developer = exampleDeveloper();
		}
		return this.developer;
	}
	
	private Developer exampleDeveloper() throws Exception, FormattingException {
		Developer developer = new Developer();
		developer.setName("abcd");
		return developer;
	}
}
