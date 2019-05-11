package com.group5.featuretests;

import com.group5.projectplanner.app.Activity;
import com.group5.projectplanner.app.ActivityID;
import com.group5.projectplanner.app.FormattingException;
import com.group5.projectplanner.app.NullObjectException;

public class ActivityHelper {
	private Activity activity;
	
	public Activity getActivity() throws Exception, FormattingException, NullObjectException {
		if (activity == null) {
			activity = exampleActivity();
		}
		return this.activity;
	}
	
	
	private Activity exampleActivity() throws Exception, FormattingException, NullObjectException {
		Activity activity = new Activity();
		ActivityID activityID = new ActivityID();
		activity.setID(activityID);
		activity.setName("Tes");
		activity.setActivityStartYear("2020");
		return activity;
	}
}