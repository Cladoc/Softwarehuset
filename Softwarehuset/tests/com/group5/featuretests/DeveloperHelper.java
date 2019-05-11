package com.group5.featuretests;

import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.Developer;
import com.group5.projectplanner.app.DeveloperID;

public class DeveloperHelper {

//Author: Casper (s163950)
private Developer developer;
	
	public Developer exampleDevLead() throws Exception, FormattingException {
		Developer developer = new Developer();
		developer.setName("Lead");
		return developer;
	}
	
	public Developer exampleDeveloper() throws Exception, FormattingException {
		Developer developer = new Developer();
		developer.setName("DevA");
		return developer;
	}
	
	public Developer exampleDeveloperTwo() throws Exception, FormattingException {
		Developer developer = new Developer();
		developer.setName("DevB");
		return developer;
	}
	
	public Developer exampleDeveloperThree() throws Exception, FormattingException {
		Developer developer = new Developer();
		developer.setName("DevC");
		return developer;
	}
	
	
}
