Feature: Get project information
Description: Project leader gets project info
Actors: Project leader

Scenario: Get project information
Given a developer is project leader on a project registered in the project planner
When the project leader requests project information
Then the project leader has access to the project information