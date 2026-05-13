Feature: Events Filtering

  Scenario: Filter events by Time (Upcoming)
    Given the Events page is opened
    When I filter the events by time "Upcoming"
    Then I should see only future events

  Scenario: Filter events by Time (Past)
    Given the Events page is opened
    When I filter the events by time "Past"
    Then I should see past events and recordings

  Scenario: Filter events by Language
    Given the Events page is opened
    When I filter the events by language "English"
    Then the event cards should display "En" language tags
