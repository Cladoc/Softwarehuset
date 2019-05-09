Feature: Get Incomplete Activities
Description: Project leader gets a list of incomplete activities
Actors: Project leader

Scenario: Get incomplete activities
Given a developer is project leader on a project registered in the project planner
And there is registered 1 incomplete activity
When the project leader requests a list of incomplete activities
Then the project leader gets a list of incomplete activities with 1 activity

Scenario: Incomplete activities has no complete activities
Given a developer is project leader on a project registered in the project planner
And there is registered 0 incomplete activity
When the project leader requests a list of incomplete activities
Then the project leader gets a list of incomplete activities with 0 activity

Scenario: Get more incomplete activities
Given a developer is project leader on a project registered in the project planner
And there is registered 4 incomplete activity
When the project leader requests a list of incomplete activities
Then the project leader gets a list of incomplete activities with 4 activity

Scenario: Developer is not project leader
Given that a developer is registered in the project planner
And a project is registered in the project planner
And that he is not project leader on the project
When the developer tries to get a list of incomplete activities
Then he gets the error message "ID not project leader"

#Scenario: There are no incomplete activities
#Given a project is registered in the project planner
#And a developer is project leader on the project
#And there are 0 activities in the project
#When the project leader requests a list of incomplete activities in the project
#Then he gets the error message "No activities registered"

