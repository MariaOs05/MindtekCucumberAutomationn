@regression @ui @MB-70
Feature: Validating Login Functionality


@smoke @loginPositive @MB-70
  Scenario: Validating login functionality with valid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "test"
    Then User is successfully lands on the homepage

  @smoke @loginNegative
  Scenario: Validating login functionality with invalid credentials
    Given User navigates to application
    When User logs in with username "Tester" and password "Tester"
    Then User validates error message "Invalid Login or Password."