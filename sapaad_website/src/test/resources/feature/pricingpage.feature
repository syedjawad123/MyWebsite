Feature: Verify the functionality of pricing page

  Scenario: User selects a monthly plan
    Given user is on homepage
    When User click on pricing it should take to pricing page
    And User selects a single outlet it should show as the selected plan is for one month
    And User selects all the Addons
    And click on try free
    Then user should be taken to trail page

  Scenario: User selects a yearly plan
    Given user is on homepage
    When User click on pricing it should take to pricing page
    And user toggles the button on for yearly plan it should show billed monthly
    And User selects multiple outlets
    And User selects all the Addons
    And click on try free
    Then user should be taken to trail page
