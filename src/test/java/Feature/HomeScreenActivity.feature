Feature: Home screen activity

    Background:
      Given the app is running
      And I am on the home screen

    @Test
    Scenario: Search for a user
      When I search for Sara
      Then I am able to see Sara Alston on results list
      When I tap Sara Alston to view contact details
      Then I can view contact details of Sara Alston

    @Test
    Scenario: Search for a user
      When I search for Lynn
      Then I am able to see Lynn Chandler on results list
      When I tap Lynn Chandler to view contact details
      Then I can view contact details of Lynn Chandler2





