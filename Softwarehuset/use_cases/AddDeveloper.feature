Feature: Add developer to project planner
Description: Add a developer to the project planner
Actors: Developer

Scenario: Add a developer successfully
Given that a developer exists
When the developer is added to the project planner
Then the developer is added to the project planner successfully

Scenario: Fail on adding duplicate developer
Given that a developer is registered in the project planner
When the developer is added again
Then he gets the error message "Developer already exists"

Scenario: Add Developer with specific ID
Given that a developer has the ID "ANDE"
#And no other developer has the ID "ANDE"
#When the developer is added to the project planner
#Then the developer is added to the project planner successfully
