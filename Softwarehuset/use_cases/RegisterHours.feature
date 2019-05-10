Feature: Register hours
Description: Developer registers work hours
Actors: Developer

Scenario: Developer sets registered hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours 8.0 in week 42 and year 2019 for the activity named "ActivityTest"
Then the developer has registered work hours 8.0 in week 42 and year 2019 for the activity named "ActivityTest"
