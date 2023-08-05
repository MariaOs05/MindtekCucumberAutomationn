
@regression @ua @etsy
Feature: Validating Search functionality
  #Background will run steps below once for each Scenario.Scenario
Background: Repeated Steps
    Given User navigates to Etsy application
    When  User searches for "carpet"
@itemDescription
  Scenario: Validating search result matches the searched item
    Then User validates search result contains
      | carpet  |
      | rug     |
      | turkish |
      | persian |

#The values above are in DataTable format. @Then step will accept value that are below in pipes
@priceRange
  Scenario: Validating price range functionality for searched item
   And  User selects price range over 1000.00
    Then  User validates price range for items over 1000.00

