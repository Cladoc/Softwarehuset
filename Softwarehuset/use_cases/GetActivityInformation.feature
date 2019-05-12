Feature: Get activity information
Description: Developer gets activity information
Actors: Developer

Scenario: Get activity information
Given that a developer is registered in the project planner
And a project is registered in the project planner
And the project has an activity registered
When the developer requests activity information
Then the developer has access to the activity information

Scenario: Get activity information with all dates set
Given that a developer is registered in the project planner
And a project is registered in the project planner
And the project has an activity registered
And the activity has start year "2020", end year "2021", start week "20" and end week "20"
And the activity has total expected hours "9000"
And the activity is complete
And that a developer with the ID "ANDE" exists
And the developer is registered in the project planner
And the developer is registered in the activity 
When the developer requests activity information
Then the developer has access to all the activity information

Scenario: Developer gets a list of 1 activity ID
Given that a developer is registered in the project planner
And a project is registered in the project planner
And 1 activity is registered on the project
When the developer requests a list of activity IDs
Then the developer has access to a list of 1 activity IDs

Scenario: Developer gets a list of 5 project IDs
Given that a developer is registered in the project planner
And 5 project is registered in the project planner
When the developer requests a list of project IDs
Then the developer has access to a list of 5 project IDs
