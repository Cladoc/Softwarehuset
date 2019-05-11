Feature: Create Project
Description: A project is added to the project planner 
Actors: Developer  

Scenario: Add a project successfully  
Given that a developer is registered in the project planner
And a project exists
When the developer adds a project to the project planner
Then the project is added to the project planner

#Scenario: Create multiple projects successfully
#Given that a developer is registered in the project planner
#When the developer adds a project with the name "Robot Software" and start year of "2020"
#And the developer adds another project with the name "Robot Software II" and start year of "2020"
#Then the projects are added to the project planner

#Scenario: Add a project with letters for date  
#Given that a developer is registered in the project planner
#When the developer adds a project with the name "Robot Software" and start year of "abc"
#Then he gets the error message "Incorrect date format"  

#Scenario: Add a project with invalid number  
#Given that a developer is registered in the project planner
#When the developer adds a project with the name "Robot Software" and start year of "12"  
#Then he gets the error message "Incorrect date format"  

#Scenario: Project is already registered  
#Given that a developer is registered in the project planner  
#And a project is registered with the name "Robot Software" 
#When the developer adds a project with the name "Robot Software" and start year of "2021"
#Then he gets the error message "A project with the specified name is already registered" 

#Scenario: Not registered developer creates project  
#Given that a developer is not registered in the project planner
#When the developer adds a project with the name "Robot Software" and start year of "2020"  
#Then he gets the error message "Invalid ID"