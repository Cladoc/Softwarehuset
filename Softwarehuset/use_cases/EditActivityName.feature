Feature: Edit activity name
Description: Project leader edits name of activity
Actors: Project leader

Scenario: Edit activity name of activity successfully
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets activity name to "TestName"
Then the activity has the name "TestName"

Scenario: Give an invalid activity name
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the project leader sets an invalid activity name of "1TestName"
Then he gets the error message "An invalid activity name was entered" 

Scenario: Failure when editing an activity name to a name already existing
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
And an activity with the name "TestName" is added to the project
When the project leader sets the activity "ActivityTest" name to "TestName"
Then he gets the error message "Activity name already existing"

#Scenario: Developer is not project leader
#Given that a developer is registered in the project planner
#And a project is registered in the project planner
#And that he is not project leader on the project
#And an activity with the name "ActivityTest" is added to the project
#When the developer sets activity name to "TestName"
#Then he gets the error message "ID not project leader"

#Scenario: Project does not exist
#Given a project does not exist

#Scenario: Activity does not exist
#Given a developer is project leader on a project registered in the project planner
#When the project leader sets activity "ActivityTest" name to "TestName"
#Then the project leader gets the error message "Activity does not exist"

Scenario: Developer attempts to edit activityName
Given a developer is project leader on a project registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When a developer sets activity name to "name test"
Then he gets the error message "ID not project leader"