Feature: Edit project date
Description: Project leader edits date of project
Actors: Project leader

Scenario: Edit start date of the project
Given a developer is project leader on a project registered in the project planner
When the project leader sets start date of week "42" and year "2020"
Then the project has start date week 42 and year 2020

Scenario: Give an invalid year date of project
Given a developer is project leader on a project registered in the project planner
And the project has end date of week "43" and year "2020"
When the project leader sets an invalid start date of week "44" and year "2020"
Then he gets the error message "An invalid start date was entered"

Scenario: Give an invalid start week of project
Given a developer is project leader on a project registered in the project planner
And the project has end date of week "43" and year "2020"
When the project leader sets an invalid start date of week "42" and year "2021"
Then he gets the error message "An invalid start date was entered"

Scenario: Give an out of bound start week of project
Given a developer is project leader on a project registered in the project planner
And the project has end date of week "43" and year "2020"
When the project leader sets an invalid start date of week "-1" and year "2019"
Then he gets the error message "Incorrect date format"


Scenario: Edit end date of the project 
Given a developer is project leader on a project registered in the project planner
When the Project leader sets end date of week "44" and year "2021"
Then the project has end date of week 44 and year 2021

Scenario: Give an invalid end week of project
Given a developer is project leader on a project registered in the project planner
And the project has start date of week "42" and year "2020"
When the project leader sets invalid end date of week "41" and year "2020"
Then he gets the error message "An invalid end date was entered"

Scenario: Give an invalid end year of project
Given a developer is project leader on a project registered in the project planner
And the project has start date of week "42" and year "2020"
When the project leader sets invalid end date of week "43" and year "2019"
Then he gets the error message "An invalid end date was entered"

Scenario: Give a letter as a start year of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets start date as letters of week "20" and year "twentytwenty"
Then he gets the error message "Incorrect date format"	

Scenario: Give a letter as a start week of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets start date as letters of week "twenty" and year "2019"
Then he gets the error message "Incorrect date format"	

Scenario: Give an out of bound end week of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets an invalid end date of week "-1" and year "2022"
Then he gets the error message "Incorrect date format"

Scenario: Give an out of bound end week of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets an invalid end date of week "42" and year "900"
Then he gets the error message "Incorrect date format"

Scenario: Give a letter as an end year of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets end date as letters of week "45" and year "twentytwenty"
Then he gets the error message "Incorrect date format"

Scenario: Give a letter as an end week of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets end date as letters of week "twentytwenty" and year "2021"
Then he gets the error message "Incorrect date format"

Scenario: Developer attempts to edit start date
Given that a developer is registered in the project planner
And a project is registered in the project planner
When the developer sets start date of week "42" and year "2020"
Then he gets the error message "ID not project leader"


Scenario: Developer attempts to edit end date
Given that a developer is registered in the project planner
And a project is registered in the project planner
When the developer sets end date of week "42" and year "2020"
Then he gets the error message "ID not project leader"


Scenario: Fail when non registered developer sets project start year
Given a developer is project leader on a project registered in the project planner
When an unregistered developer tries to set the project start year
Then he gets the error message "Invalid ID"

Scenario: Fail when non registered developer sets project start week
Given a developer is project leader on a project registered in the project planner
When an unregistered developer tries to set the project start week
Then he gets the error message "Invalid ID"

Scenario: Fail when non registered developer sets project end year
Given a developer is project leader on a project registered in the project planner
When an unregistered developer tries to set the project end year
Then he gets the error message "Invalid ID"

Scenario: Fail when non registered developer sets project end week
Given a developer is project leader on a project registered in the project planner
When an unregistered developer tries to set the project end week
Then he gets the error message "Invalid ID"