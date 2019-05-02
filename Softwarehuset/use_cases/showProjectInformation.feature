Feature: Show Project information
Description: Project leader gets project information
Actors: Project leader

Scenario: Project leader gets project info
Given a developer is project leader on a project registered in the project planner
When the project leader asks for the project information
Then projectInformation is "project information"