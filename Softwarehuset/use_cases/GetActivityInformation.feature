Feature: Get project information
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
When the developer requests activity information
#Then the developer has access to all the activity information