Feature: Community Navigation

  Scenario: Open community details
    Given I am on the homepage
    When I click on the first community card
    Then I should be redirected to the community detail page
    And I should see the community title