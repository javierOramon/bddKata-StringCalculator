Feature: Add method
  A string calculator that can take string inputs using the Add method and returns an integer.

  Scenario: Add two numbers to form a sum in the string calculator
    Given you input of "1,2"
    When you process this input
    Then the result will be 3

  Scenario: Input 1 string in string calculator
    Given you input of "1"
    When you process this input
    Then the result will be 1