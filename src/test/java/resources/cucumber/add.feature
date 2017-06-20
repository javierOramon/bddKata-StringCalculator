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

  Scenario: Empty string in string calculator
    Given you input of ""
    When you process this input
    Then the result will be 0

  Scenario: Input 0 string in string calculator
    Given you input of "0"
    When you process this input
    Then the result will be 0

  Scenario: String calculator can handle an unknown amount of numbers
    Given you input of "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20"
    When you process this input
    Then the result will be 210

  Scenario: String calculator can handle new lines between numbers instead of commas
    Given you input of "1\n2,3"
    When you process this input
    Then the result will be 6

  Scenario: Support different delimiters
        # The delimiter should be followed after "//" and a new line separating the delimiter and the numbers. E.g. //[delimiter]\n[numbers…]
    Given you input of "//;\n1;2"
    When you process this input
    Then the result will be 3