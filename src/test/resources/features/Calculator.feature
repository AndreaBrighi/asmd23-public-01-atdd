Feature:  Adding numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to add numbers using a Calculator

  Scenario:  Add two positive numbers
    Given I have a Calculator
    When I insert 1
    And I press +
    And I insert 1
    And I press =
    Then the result should be 2

  Scenario:  Add a positive and negative number
    Given I have a Calculator
    When I insert 1
    And I press +
    And I insert -1
    And I press =
    Then the result should be 0

  Scenario:  Add two negative numbers
    Given I have a Calculator
    When I insert -1
    And I press +
    And I insert -1
    And I press =
    Then the result should be -2

  Scenario:  Add two decimal numbers
    Given I have a Calculator
    When I insert 1.5
    And I press +
    And I insert 1.5
    And I press =
    Then the result should be 3

  Scenario:  Add two positive numbers with a pre-given value
    Given I have a Calculator
    And I have a pre-given value of 1
    When I press +
    And I insert 1
    And I press =
    Then the result should be 2

  Scenario:  Subtract two positive numbers
    Given I have a Calculator
    When I insert 1
    And I press -
    And I insert 1
    And I press =
    Then the result should be 0