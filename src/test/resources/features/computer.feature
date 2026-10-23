@feature_login
Feature: Login Feature

  @smoke @login
  Scenario: Valid Login test
    Given user is on Login Page
    When user enters valid username aur passowrd
    Then user should be logged in successfuly

  @regression @login
  Scenario: Valid Login test
    Given user is on Login Page
    When user enters invalid username aur passowrd
    Then error  message should be displayed