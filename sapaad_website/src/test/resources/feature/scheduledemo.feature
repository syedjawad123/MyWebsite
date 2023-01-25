Feature: User applies for a demo

  Scenario Outline: User should be able to apply for a demo
    Given User is on sapaad home
    When user click on Schedule  demo button
    And Schedule demo page opens
    And user selects there role restaurant type
    And the number of Outlets they have and click on continue
    And user enters there contact details <name> and <email> and  <restaurant> and <phone> and submits the form
    Then User gets a message thank you for your interest

    Examples: 
      | name     | email                 | restaurant  | phone      |
      | SapaadQA | sapaadQ121A@gmail.com | Sapaad cafe | 2313121231 |
