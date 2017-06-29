Feature: Calculate method

  Scenario Outline: Division with the Calculate method of the string calculator
    Given an input of <input>
    When you run the Calculate method
    Then the result will be a <result>
    Examples:
      | input | result |
      | "2 / 5" | "0.4" |
      | "1 / 2" | "0.5" |
      | "1 / 0" | "Cannot divide by zero" |
      | "0 / 0" | "Result is undefined" |

  Scenario Outline: Decimal numbers should be limited to 4 decimal places and rounding up and down is factored into the result
    Given an input of <input>
    When you run the Calculate method
    Then the result will be a <result>
    Examples:
      | input | result |
      | "1 / 6"  | "0.1667" |
      | "1 / 3" | "0.3333" |
      | "16 / 6" | "2.6667" |
#
#  Scenario outline: Negative numbers while dividing with the Calculate method of the string calculator
#    Given an input of <input>
#    When you run the Calculate method
#    Then an exception will be shown <exception>
#      | input | result |
#      | -2 / 5 | no negatives allowed |
#      | -1 / 3 | no negatives allowed |
#      | -1 / 0 | no negatives allowed |
#
#  Scenario outline: Numbers bigger than 1000 should be ignored by the string calculator during division
#    Given an input of <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 1 / 4000 | 1 |
#      | 100 / 8250 | 100 |
#      | 150 / 2200 | 150 |
#
#  Scenario outline: Addition with the Calculate method of the string calculator
#    Given your input is an addition <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 2 + 4 | 6 |
#      | 10 + 25 | 35 |
#      | 150 + 225 | 375 |
#
#  Scenario outline: Negative numbers while adding with the Calculate method of the string calculator
#    Given an input of <input>
#    When you run the Calculate method
#    Then an exception will be shown <exception>
#      | input | result |
#      | -2 + 7 | no negatives allowed |
#      | -1 + 6 | no negatives allowed |
#      | -1 + 0 | no negatives allowed |
#
#  Scenario outline: Numbers bigger than 1000 should be ignored by the string calculator during addition
#    Given an input of <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 2 + 4000 | 2 |
#      | 100 + 8250 | 100 |
#      | 150 + 2200 | 150|
#
#  Scenario outline: Subtraction with the Calculate method of the string calculator
#    Given your input is a subtraction <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 4 -2 |  2 |
#      | 5 - 1 | 4 |
#      | 222 - 112 | 110 |
#
#  Scenario outline: Negative numbers while subtracting with the Calculate method of the string calculator
#    Given an input of <input>
#    When you run the Calculate method
#    Then an exception will be shown <exception>
#      | input | result |
#      | -2 - 7 | no negatives allowed |
#      | -1 - 6 | no negatives allowed |
#      | -1 - 0 | no negatives allowed |
#
#  Scenario outline: Numbers bigger than 1000 should be ignored by the string calculator during subtraction
#    Given an input of <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 2 - 4000 | 2 |
#      | 100 - 8250 | 100 |
#      | 150 - 2200 | 150 |
#
#  Scenario outline: Multiplying with the Calculate method of the string calculator
#    Given you input is a multiplication <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 2 * 4 | 8 |
#      | 8 * 9 | 72 |
#      | 10 * 1 | 10 |
#      | 0 * 0 | 0 |
#      | 1 * 1 | 1 |
#
#  Scenario outline: Negative numbers while multiplying with the Calculate method of the string calculator
#    Given an input of <input>
#    When you run the Calculate method
#    Then an exception will be shown <exception>
#      | input | result |
#      | -4 * 7 | no negatives allowed |
#      | -1 * 3 | no negatives allowed |
#      | -1 * 0 | no negatives allowed |
#
#  Scenario outline: Numbers bigger than 1000 should be ignored by the string calculator during multiplication
#    Given an input of <input>
#    When you run the Calculate method
#    Then the result will be <result>
#      | input | result |
#      | 2 * 4000 | 2 |
#      | 100 * 8250 | 100 |
#      | 150 *  2200 | 150 |
#
#  Scenario: Empty string in string calculator
#    Given you input ""
#    When you process this input
#    Then the string calculator will return 0
#
#  Extra scenarios (to add complexity - needs to be discussed):
#
#  Scenario: Addition with parentheses for the string calculator
#    Given you input (86 + 74) + 26
#    When you run the Calculate method
#    Then the result will be 186
#
#  Scenario: Multiplication with parentheses for the string calculator
#    Given you input (660 * 31) + (660 * 69)
#    When you run the Calculate method
#    Then the result will be 66000
#
#  Scenario: BODMAS for the string calculator
#    Given you input 7 / 3 + 3 * 8 - 1 * 6
#    When you run the calculate method
#    Then the result will be 250
#
#  Scenario: Extra BODMAS for the string calculator
#    Given you input 4 * 5 / 2 + 7
#    When you run the Calculate method
#    Then the result will be 17