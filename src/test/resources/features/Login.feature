@login
Feature: User should be able to login with valid credentials

  Background:
    Given The user is on the login page


  Scenario Outline: Positive Login Test
    When The user enters "<valid username>" and "<valid password>" credential
    Then The user should be able to login swag labs website
    Examples:
      | valid username          | valid password |
      | standard_user           | secret_sauce   |
      | problem_user            | secret_sauce   |
      | performance_glitch_user | secret_sauce   |

  @wip
  Scenario Outline: Negative Login Test
    When The user enters invalid or empty "<username>" or "<password>" credential
    Then The user should be able see the "<error message>"
    Examples:
      | username        | password     | error message                                                             |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | standard_user   | 123          | Epic sadface: Username and password do not match any user in this service |
      | standard        | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user   |              | Epic sadface: Password is required                                        |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      |                 |              | Epic sadface: Username is required                                        |

