Feature: Edit project name
Description: Project leader edits date of project
Actors: Project leader

Scenario: Edit start date of the project
Given a developer is project leader on a project registered in the project planner
When the project leader sets projectName to "TestName"
Then the project has the name "TestName"

Scenario: Give an invalid start date of project
Given a developer is project leader on a project registered in the project planner
When the project leader sets an invalid projectName of "1TestName"
Then he gets the invalid name error message "An invalid project name was entered"