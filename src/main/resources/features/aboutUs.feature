Feature: About Us Page Verification

  Scenario: Navigate to Instagram from the About Us page
    Given the About Us page is opened
    When the Instagram icon is visible on the page
    And the Email icon is visible on the page
    Then I click on the Instagram icon
    And I should be on instagram