@GetNegative
Feature: Validate Get Place API is working as expected

  Rule: Creating Data for Add Place API to validate Get Place
    Example: Setting up Data for Negative Scenarios
      Given When user hits API with "Ajay","Gwalior","Gwalior" data
      When user hits "POST" for "AddPlace"
      Then Validate user is getting status code as 200
      And store "place_id" in "PLACE_ID" to use for Get Place API

    Scenario Outline: Validating Get Place API <status_code>
      Given When user hits API with <placeId> of Add Place API
      When user hits "GET" for "GetPlace"
      Then Validate user is getting status code as <status_code>

      Examples:
        | placeId                          | status_code |
        | null                             | 404         |
        | c196610021808d8e4eeea90182856fe9 | 200         |
