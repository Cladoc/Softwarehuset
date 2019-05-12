Feature: Edit project name
Description: Project leader edits name of project
Actors: Project leader

Scenario: Edit project name of project successfully
Given a developer is project leader on a project registered in the project planner
When the project leader sets projectName to "TestName"
Then the project has the name "TestName"

Scenario: Give an invalid project name 
Given a developer is project leader on a project registered in the project planner
When the project leader sets an invalid projectName of "1TestName"
Then he gets the error message "An invalid project name was entered"