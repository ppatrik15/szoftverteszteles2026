Feature: Speakers List Bug Fix Verification

  Scenario: Verify speakers list loads successfully without error
    Given I am on the homepage
    When I click on the "Speakers" link in the footer
    Then a full grid of speaker cards should be displayed
    And I should not see the "Can't load speakers list" error message
