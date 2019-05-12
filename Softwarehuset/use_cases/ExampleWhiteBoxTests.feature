Feature: Whitebox tests
Description: Goes through each whitebox tested as described in report
Actor: Developer, Project leader

#1 test
Scenario: Add developer successfully
Given a developer exists with an ID
And the project planner has no developer registered with the same ID
When developer is registered in the project planner
Then the developer is registered in the project planner successfully

Scenario: Fail on adding duplicate developer
Given a developer exists with an ID
And another developer exists with an ID of the same name
And the second developer is registered in the project planner
When the first developer is added to the project planner
Then he gets the error message "Developer already exists"

#2 test
Scenario: Add project successfully
Given a developer exists with an ID
And the developer is in the project planner
And a project exists with an ID
And the project is not registered in the project planner
When the project is added to the project planner
Then the project is added to the project planner successfully

Scenario: Fail on adding duplicate project
Given a developer exists with an ID
And the developer is in the project planner
And a project exists with an ID
And a second project exists with the same ID
And the second project is in the project planner
Then the project repository contains 1 project
When the first project is added to the project planner
Then he gets the error message "A project with the specified name is already registered"
And the project repository is unchanged

#3 test
Scenario: Confirm that developer is in the project planner
Given a developer exists with an ID
And the developer is in the project planner
When a developer checks if the developer is registered in the project planner
Then it is confirmed that the developer is registered in the project planner

Scenario: Refute that developer is in the project planner when list is empty
Given a developer exists with an ID
When a developer checks if the developer is registered in the project planner
Then it is refuted that the developer is registered in the project planner

Scenario: Refute that developer is in the projet planner when his ID does not match any of the registered developers
Given a developer exists with an ID
And a second developer exists with a different ID from the first developer
And the second developer is registered in the project planner
When a developer checks if the developer is registered in the project planner
Then it is refuted that the developer is registered in the project planner

#4 test
