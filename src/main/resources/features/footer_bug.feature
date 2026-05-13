Feature: Footer Content Bug Fix Verification

  Scenario: Verify technical placeholder is not visible in footer
    Given I am on the homepage
    When I scroll to the footer
    Then the footer should display meaningful text
    And I should not see the technical placeholder "qc6Crd6CXiTgTum"
