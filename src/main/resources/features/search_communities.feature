Feature: Community Search

  Scenario: Search returns results
    Given I am on the homepage
    When I enter "QA" into the search bar
    And I press enter
    Then I should see a list of communities related to "QA"

  Scenario: Search returns no results
    Given I am on the homepage
    When I enter "asdasdasd123123" into the search bar
    And I press enter
    Then I should see a "No communities found" message