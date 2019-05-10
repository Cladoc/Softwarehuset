Feature: Register hours
Description: Developer registers work hours
Actors: Developer

Scenario: Developer sets registered hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "42" and year "2019" for the activity named "ActivityTest"
Then the developer has registered work hours 8.0 in week 42 and year 2019 for the activity named "ActivityTest"

Scenario: Developer sets registered hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the developer registers work hours "9.0" in week "42" and year "2019" for the activity named "ActivityTest"
Then the developer has registered work hours 17.0 in week 42 and year 2019 for the activity named "ActivityTest"

Scenario: Developer sets registered hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "42" and year "2019" for the activity named "ActivityTest"
When the developer registers work hours "9.0" in week "43" and year "2019" for the activity named "ActivityTest"
Then the developer has registered work hours 9.0 in week 43 and year 2019 for the activity named "ActivityTest"

Scenario: Developer sets registered hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "42" and year "2019" for the activity named "ActivityTest"
Then the developer has registered work hours 0.0 in week 41 and year 2019 for the activity named "ActivityTest"

Scenario: Developer gives invalid input for hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "abekat" in week "42" and year "2019" for the activity named "ActivityTest"
Then he gets the error message "Incorrect input"

Scenario: Developer sets invalid hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "101" in week "42" and year "2019" for the activity named "ActivityTest"
Then he gets the error message "Input hours not within boundaries"

Scenario: Developer sets invalid hours
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "-1.0" in week "42" and year "2019" for the activity named "ActivityTest"
Then he gets the error message "Input hours not within boundaries"

Scenario: Developer sets invalid work week
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "54" and year "2019" for the activity named "ActivityTest"
Then he gets the error message "Invalid week entered"

Scenario: Developer sets invalid work week
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "-1" and year "2019" for the activity named "ActivityTest"
Then he gets the error message "Invalid week entered"

Scenario: Developer sets invalid work year
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "42" and year "3000" for the activity named "ActivityTest"
Then he gets the error message "Invalid year entered"

Scenario: Developer sets invalid work year
Given a developer with ID "abcd" is registered in the project planner
And a project is registered in the project planner
And an activity with the name "ActivityTest" is added to the project
When the developer registers work hours "8.0" in week "42" and year "1999" for the activity named "ActivityTest"
Then he gets the error message "Invalid year entered"