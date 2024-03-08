@Post
Feature: Validate Add Place API is working as expected

  Scenario Outline: Validate Add Place API is working as per below data set
    Given When user hits API with <Name>,<Address>,<Phone_Num> data
    When user hits "POST" for "AddPlace"
    Then Validate user is getting status code as 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"


    Examples:
      | Name   | Address | Phone_Num |
      | Ajay   | Gwalior | 213       |
      | Prachi | Noida   | 6823      |
      | Nikhil | Gurgaon | 091327    |