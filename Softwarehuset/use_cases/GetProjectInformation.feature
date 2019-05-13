Feature: Get project information
Description: Project leader gets project info
Actors: Developer

Scenario: Developer requests project information with all information set
Given a developer is project leader on a project registered in the project planner
And the project has start year "2020", end year "2021", start week "20" and end week "20"
When the project leader requests project information
Then the project leader has access to all the project information

Scenario: Developer gets a list of 1 project ID
Given that a developer is registered in the project planner
And 1 project is registered in the project planner
When the developer requests a list of project IDs
Then the developer has access to a list of 1 project IDs

Scenario: Developer gets a list of 5 project IDs
Given that a developer is registered in the project planner
And 5 project is registered in the project planner
When the developer requests a list of project IDs
Then the developer has access to a list of 5 project IDs
