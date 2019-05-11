Feature: Remove developer to project planner
Description:
Actors: Developer

Scenario: Remove a developer successfully
Given that a developer with the ID "abcd" exists
And the developer is added to the project planner
When the developer is removed from the project planner
Then the developer is removed from the project planner successfully

Scenario: Fail on removing non existant developer
Given that a developer with the ID "abcd" is not registered in project planner
When the developer is removed from the project planner
Then he gets the error message "Developer not registered in project planner"