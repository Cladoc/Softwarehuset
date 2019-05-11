Feature: Get project information
Description: Project leader gets project info
Actors: Project leader

Scenario: Get project information
Given a developer is project leader on a project registered in the project planner
When the project leader requests project information
Then the project leader has access to the project information

Scenario: Get project information with all dates set
Given a developer is project leader on a project registered in the project planner
And the project has start year "2020", end year "2021", start week "20" and end week "20"
When the project leader requests project information
Then the project leader has access to all the project information

Scenario: A non-leader developer gets project information
Given a developer is registered in the project planner
