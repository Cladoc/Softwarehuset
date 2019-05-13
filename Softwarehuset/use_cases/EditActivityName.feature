Feature: Edit activity name
Description: Project leader edits name of activity
Actors: Project leader

Scenario: Edit activity name of activity successfully
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets activity name to "TestName"
Then the activity has the name "TestName"

Scenario: Give an invalid activity name
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets an invalid activity name of "1TestName"
Then he gets the error message "An invalid activity name was entered" 

Scenario: Failure when editing an activity name to a name already existing
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And an activity with the name "TestName" is added to the project
When the project leader sets the activity "ActivityTest" name to "TestName"
Then he gets the error message "Activity name already existing"

Scenario: Fail when non registered developer sets activity name
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When an unregistered developer tries to set the activity name
Then he gets the error message "Invalid ID"