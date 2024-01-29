# new feature
# Tags: optional

Feature: Login Functionality for ParaBank Website

  I am a user of the ParaBank website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the ParaBank login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully

    Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<An internal error has occurred and has been logged>"

      Examples:
        | username       | password        | An internal error has occurred and has been logged        |
        | talalhassan    | talal12345      | Error: An internal error has occurred and has been logged |
        | Durga          | invalidPassword | Error: An internal error has occurred and has been logged |
        | Qaisar Mehmood | invalidPassword | Error: An internal error has occurred and has been logged |

  Scenario: Navigating to the forgotten password page
    When I click on the "Forgot login info?" link
    Then I should be redirected to the customer lookup form