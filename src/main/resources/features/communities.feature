Feature: Communities page

  Scenario: Verify community cards are present on the page
    Given the Communities page is opened
    Then at least one community card is visible on the page

  Scenario: Search for a specific community by keyword
    Given the Communities page is opened
    When I search for "Global Testing"
    Then community cards related to the search should be displayed