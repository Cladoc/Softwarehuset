Feature: Set Expected Work Hours for activity
Description: Developer registers expected work hours for activity
Actors: Project leader

Scenario: Project leader sets expected work hours
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets expected work hours to "8.0"
Then the activity has expected work hours set to 8.0
	
Scenario: Project leader incorrectly sets expected work hours
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets expected work hours to "NAN"
Then he gets the error message "Work hours incorrect format"

Scenario: Develoer sets expected work hours
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When a developer sets expected work hours to "8.0"
Then he gets the error message "ID not project leader"