Feature: Online Event Functionality

  Scenario: Verify "Join Online" button is active for future event
    Given the user is viewing an upcoming online event
    Then the "Join Online" button should be active