
Feature: Validate Get Place API is working as expected

  Background: : Creating Data for Add Place API to validate Get Place
    Given When user hits API with "Ajay","Gwalior","Gwalior" data
    When user hits "POST" for "AddPlace"
    Then Validate user is getting status code as 200
    And store "place_id" to use for Get Place API

    Scenario: Validating Get Place API
      Given When user hits API with placeId of Add Place API
      When user hits "GET" for "GetPlace"
      Then Validate user is getting status code as 200
