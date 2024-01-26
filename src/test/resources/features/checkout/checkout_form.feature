Feature: Checkout Form Test

  Scenario: Fill out the checkout form and submit via Credit Card
    Given User navigates to the checkout page
    When User enters first name "John"
    And User enters last name "Doe"
    And User enters address "Apartment 1"
    And User selects country "United States"
    And User enters zip code "90210"
    And User selects payment method "Credit Card"
    And User clicks the Submit button
    Then User should see no errors


  Scenario: Fill out the checkout form and submit via Debit Card
    Given User navigates to the checkout page
    When User enters first name "John"
    And User enters last name "Doe"
    And User enters address "Apartment 1"
    And User selects country "United States"
    And User enters zip code "90210"
    And User selects payment method "Credit Card"
    And User clicks the Submit button
    Then User should see no errors

    # run in terminal
    # mvn clean verify
    # to execute the bdd script