Feature: Get Available Developers
Description: Project leader gets a list of developerIDs of available developers
Actors: Project leader

Scenario: Get available developers
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "8.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "42" an year "2019"
Then the project leader gets a list of available developers ID with 2 developerIDs

Scenario: Get available developers
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "42" an year "2019"
Then the project leader gets a list of available developers ID with 1 developerIDs

Scenario: Get available developers with invalid week number
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "54" an year "2019"
Then he gets the error message "Invalid week entered"

Scenario: Get available developers with invalid week number
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "-1" an year "2019"
Then he gets the error message "Invalid week entered"

Scenario: Get available developers with invalid year number
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "42" an year "3000"
Then he gets the error message "Invalid year entered"

Scenario: Get available developers with invalid year number
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "42" an year "1999"
Then he gets the error message "Invalid year entered"

Scenario: Get available developers with invalid year number
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "42" an year "Nej"
Then he gets the error message "Incorrect input"

Scenario: Get available developers with invalid week number
Given a developer is project leader on a project registered in the project planner
And a developer with ID "bcde" is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the developer with the id "bcde" has registered work hours "41.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the project leader requests a list of available developer IDs in week "nej" an year "2019"
Then he gets the error message "Incorrect input"