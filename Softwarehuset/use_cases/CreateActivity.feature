Feature: Create activity
Description: An activity is added to a project
Actors: Project leader

Scenario: Add an activity successfully
Given a developer is project leader on a project registered in the project planner
When the project leader adds an activity with the name "refactoring"
Then the activity with name "refactoring" is added to the project

Scenario: Activity is already registered
Given a developer is project leader on a project registered in the project planner
And an activity with the name "refactoring" is added to the project
When the project leader adds an activity with the name "refactoring" again
Then he gets the error message "Activity already exists"

Scenario: Developer is not project leader
Given that a developer is registered in the project planner
And a project is registered in the project planner
And that he is not project leader on the project
When the developer tries to add an activity with the name "refactoring"
Then he gets the error message "ID not project leader"