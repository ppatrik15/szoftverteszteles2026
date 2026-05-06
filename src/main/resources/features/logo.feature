Feature: Navigate using Logo

  Scenario: Return to homepage via logo
    Given I am on the homepage
    When I click on the first community card
    Then I should be redirected to the community detail page
    When I click the site logo
    Then I should be redirected to the homepage
    And I should see a list of community cards