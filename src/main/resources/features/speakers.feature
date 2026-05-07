Feature: Speakers Page Functionality

  Scenario: Verify "Can't load speakers list" error
    Given the user is on the homepage
    When the user navigates to the "Speakers" page
    Then the page should display the "Can't load speakers list" error message