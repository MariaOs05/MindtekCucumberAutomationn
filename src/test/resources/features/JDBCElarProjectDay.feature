@jdbcYard

Feature: Validating added yard is persisted in Database
  Background: 
    Given  User navigates to Elar Logistics application
    When user logs in with username "student@mindtekbootcamp.com" and password "ilovejava"
    And  User click on Yards tab
    And User clicks on Add Yard

  Scenario: Validating Yard is saved in UI and inserted correctly into table in Database(Required Fields)
    And user inputs required data
    | NAME  | STREET             |  CITY           | STATE     | ZIP CODE    | SPOTS     |
    | QWETRY| 1224 W Addison St. |  Los Angeles    | California| 60656       | 11122     |
    And user clicks on add yard button
    Then User validates Yard is correctly inserted into core_yard table in Data Base


