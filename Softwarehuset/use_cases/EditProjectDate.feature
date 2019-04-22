Feature: Edit project date
Description: Project leader edits date of project
Actors: Project leader

#Scenario: Edit start date of the project
#Given a project is registered in the project planner
#And a developer is project leader on the project
#When the project leader sets start date of week 42 and year 2020
#Then the project has start date week 42 and year 2020

#Scenario: Give an invalid start date of project
#Given a project is registered in the project planner
#And a developer is project leader on the project
#And the project has end date of week 41 and year 2020
#When the project leader sets start date of week 42 and year 2020
#Then he gets the error message "An invalid start date was entered"

#Scenario: Give a letter as a start date of project
#Given a project is registered in the project planner
#And a developer is project leader on the project
#When the project leader sets start date of week "twenty" and year "twentytwenty"
#Then he gets the error message "An invalid start date was entered"

#Scenario: Edit end date of the project 
#Given a project is registered in the project planner
#And a developer is project leader on the project
#When the Project leader sets end date of week 42 and year 2020
#Then the project has end date of week 42 and year 2021
#
#Scenario: Give an invalid end date of project
#Given a project is registered in the project planner
#And a developer is project leader on the project
#And the project has start date of week 41 and year 2020
#When the project leader sets end date of week 40 and year 2020
#Then he gets the error message "An invalid end date was entered"
#
#Scenario: Give a letter as an end date of project
#Given a project is registered in the project planner
#And a developer is project leader on the project
#When the project leader sets end date of week "twenty" and year "twentytwenty"
#Then he gets the error message "An invalid end date was entered"