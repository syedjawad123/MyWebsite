Feature: User applies for trial

  Scenario Outline: User should be able to apply the trails
    Given User is on sapaad homepage
    When User clicks on try free button
    And I enter a valid <email> address and click on continue
    And I enter the form details with <name> <restaurantname> <phone>
    And I click on agree button and submit the details
    Then User gets a message thank you for submitting the form

    Examples: 
      | email                   | name     | restaurantname | phone        |
      | sapaadqa1121231qw3@gmail.com | SapaadQA | Sapaadcafe     | 131311312123 |

  Scenario Outline: User applies for trail with the same email Id
    Given User is on sapaad Homepage
    When user clicks on try free button trail page should be displayed
    And I enter existing <email> address
    Then I get a message the email already exists and get a link for login

    Examples: 
      | email                 |
      | sapaadqa123@gmail.com |
