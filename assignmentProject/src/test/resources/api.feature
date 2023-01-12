Feature: Toronto Weather

  @TC2
  Scenario: Receive Toronto weather with successful status code
    Given User requests Toronto weather
    Then Print response body and status code