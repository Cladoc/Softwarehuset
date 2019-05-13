Feature: Set Activity complete
Description: Set a project activity as complete 
Actors: Project Leader

Scenario: Set an activity as complete
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets the activity as complete
Then the activity is registered as completed

Scenario: Fail when non registered developer sets an activity as complete
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When an unregistered developer tries to set the activity as complete
Then he gets the error message "Invalid ID"
