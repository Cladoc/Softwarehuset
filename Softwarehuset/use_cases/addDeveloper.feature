Feature: Add developer to project planner
Description:
Actors: Developer

Scenario:
Given that a developer with the ID "abcd" exists
When the developer is added to the project planner
Then the developer is added to the project planner successfully

Scenario:
Given that a developer with the ID "abcd" exists
And the developer is registered in the project planner
When the developer is added again
Then he gets the error message "ID already exists"