Feature: Calculator String Addition
  As a user, I want to enter a String of numbers separated by delimiter and get their sum

  Scenario: Addition of two numbers
    Given I have a calculator
    When I enter the string "2,3"
    Then I should have the result as 5

    When I enter the string "7,10"
    Then I should have the result as 17

  Scenario: Addition of more than two Numbers
    Given I have a calculator
    When I enter the string "4,48,3,73,1,79,77,49,63,16"
    Then I should have the result as 413

    When I enter the string "1,2,3"
    Then I should have the result as 6