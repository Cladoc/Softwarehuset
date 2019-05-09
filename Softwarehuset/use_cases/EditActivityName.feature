Feature: Edit activity name
Description: Project leader edits name of activity
Actors: Project leader

Scenario: Edit activity name of activity successfully
Given a developer is project leader on a project registered in the project planner
When the project leader sets activity name to "TestName"
Then the activity has the name "TestName"

Scenario: Give an invalid activity name 
Given a developer is project leader on a project registered in the project planner
When the project leader sets an invalid activity name of "1TestName"
Then the project leader gets the error message "An invalid activity name was entered"

Scenario: Failure when editing an activity name to a name already existing
Given a developer is project leader on a project registered in the project planner
When the project leader sets activity name to "TestName"
Then the project leader gets the error message "Activity name already existing"
