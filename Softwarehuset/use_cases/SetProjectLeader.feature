Feature: Set project leader
Description: Developer assigns a project leader
Actors: Developer

Scenario: Set project leader
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
When the developer sets developer with ID "abcd" as project leader in the project
Then the project has project leader with ID "abcd"

Scenario: Assign non-registered developer to be project leader 
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
When the developer sets developer with ID "bbbb" as project leader in the project 
Then he gets the error message "Invalid ID"

Scenario: Assign project leader to a project that does not exist
Given a developer with ID "abcd" is registered in the project planner
When the developer sets developer with ID "abcd" as project leader in the project
Then he gets the error message "Project does not exist"