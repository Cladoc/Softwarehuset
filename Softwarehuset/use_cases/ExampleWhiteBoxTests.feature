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
Scenario: Set activity start week successfully
Given a developer exists with an ID
And the developer is in the project planner
And a project exists with an ID
And the project is in the project planner
And an activity exists with an ID
And the activity is added to the project
And the activity has start year "2020"
And the activity has start week "10"
And the activity has end year "2021"
And the activity has end week "40"
When the developer sets start week "20"
Then the activity will have start week 20

Scenario: Set activity start week larger than 53
Given a developer exists with an ID
And the developer is in the project planner
And a project exists with an ID
And the project is in the project planner
And an activity exists with an ID
And the activity is added to the project
And the activity has a start week
When the developer sets start week "60"
Then he gets the error message "Incorrect date format"
And the activity start week is unchanged

Scenario: Set: Set activity start week fails when not in correct order with other set dates
Given a developer exists with an ID
And the developer is in the project planner
And a project exists with an ID
And the project is in the project planner
And an activity exists with an ID
And the activity is added to the project
And the activity has start year "2020"
And the activity has start week "10"
And the activity has end year "2020"
And the activity has end week "40"
And the activity has a start week
When the developer sets start week "41"
Then he gets the error message "An invalid start date was entered"
And the activity start week is unchanged