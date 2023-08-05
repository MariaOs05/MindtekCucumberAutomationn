@elarLogisticButtons

  Feature: Validating Elar Logistics Button functionality
    Background:
      Given  User navigates to Elar Logistics application
      When user logs in with username "student@mindtekbootcamp.com" and password "ilovejava"
      And  User click on companies tab

      Scenario: Validation of editing input field
        And User selects "AAABBBCCC" company
        And User clicks on edit button
        Then  User validates fields are editable

        Scenario: Validating company fields stay the same when user clicks on cancel button
          And User selects "AAABBBCCC" company
          And User clicks on edit button
          And User clicks on cancel button
          Then  User validates fields remain the same
@elarWithData
        Scenario: Validating company name stays the same after editing and user clicks on cancel button
          And User selects "AAABBBCCC" company
          And User clicks on edit button
          And User clicks on company name and rename it
          And User clicks on cancel button
          Then  User validates edited fields remain the same


         @backToCompanies
          Scenario: Validate that list of companies is displayed when user clicks on "Back to companies" button
         And User selects "AAABBBCCC" company
           And  User clicks back to companies button
          Then  user validates list of companies is displayed


           @creationPageValidation
           Scenario: Validating company creation page when user clicks "Add Company" button
             And User clicks on Add Company button
             Then User validates navigation to company creation page

@cantBeEdited
         Scenario: Validating form can't be edited  after clicking "Cancel" button
           And User selects "AAABBBCCC" company
           And User clicks on edit button
           And User clicks on cancel button
           Then User validates Company name can't be cleared

  @editExisting
  Scenario: Validation of editing already existing companies
    And  User selects "AAABBBCCC" company
    And User clicks on edit button
    Then User validates existing companies are editable

    @fieldsImmutable
  Scenario: Validating values of the field are immutable after clicking cancel button
      And User selects "AAABBBCCC" company
      And User clicks on edit button
      And User clicks on cancel button
      Then  Validating values of the field are immutable

      @inputSaved
      Scenario: Validating input is saved after editing fields after clicking "Save" btn
        And User selects "AAABBBCCC" company
        And User clicks on edit button
        And User clicks on company name and rename it
        And User clicks on save btn
        And User clicks on Stay on current page when pop-up is visible
        Then User validates input is saved

      @popUpsChanged
      Scenario: Validating Pop-Up says "Abc successfully changed" after user clicks on save button
        And User selects "AAABBBCCC" company
        And User clicks on edit button
        And User clicks on MC and change it
        And User clicks on save btn
        Then User validates pop-up says "AAABBBCCC successfully changed"





