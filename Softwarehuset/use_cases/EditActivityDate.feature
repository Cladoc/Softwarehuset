Feature: Edit activity date
Description: Edit start or end date of activity 
Actors: Project leader

Scenario: Edit start date of activity #ændret fra rapport 1
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets activity start date of week "42" and year "2020"
Then then activity has start date of week 42 and year 2020

Scenario: Give an invalid start date of activity
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the project has an activity with end date of week "41" and year "2020"
When the project leader sets activity start date of week "42" and year "2020"
Then he gets the error message "An invalid start date was entered"

Scenario: Give a letter as a start date of activity
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the project has an activity with end date of week "41" and year "2020"
When the project leader sets activity start date of week "twenty" and year "twentytwenty"
Then he gets the error message "Incorrect date format"

Scenario: Edit end date of the activity 
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets activity end date of week "42" and year "2020"
Then the activity has end date of week 42 in year 2020

Scenario: Give an invalid end date of activity
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And the project has an activity with start date of week "41" and year "2020"
When the project leader sets activity end date of week "40" and year "2020"
Then he gets the error message "An invalid end date was entered"

Scenario: Give a letter as an end date of activity
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets activity end date of week "twenty" and year "twentytwenty"
Then he gets the error message "Incorrect date format"