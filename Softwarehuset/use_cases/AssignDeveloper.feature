Feature: Assign developer
Description: Project leader assigns a developer
Actors: Project leader
 
Scenario: Assign developer to activity
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader assigns a developer to the activity
Then the developer is assigned to the activity

Scenario: Assign developer again
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader assigns a developer to an activity under the project where he is already assigned
Then he gets the error message "Developer already exists"