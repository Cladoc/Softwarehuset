Feature: Set project leader
Description: Developer assigns a project leader
Actors: Developer

Scenario: Set project leader
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
When the developer sets himself as project leader on the project
Then the project has project leader with ID "abcd"

Scenario: Assign non-existing developer to be project leader 
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
When the developer sets developer with ID "bbbb" as project leader in the project 
Then he gets the error message "Invalid ID"