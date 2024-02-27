Feature: LightDevice

  Scenario Outline: Turning on the light
    Given I have a light device
    And the light is <initial_state>
    When I turn <action> the light
    Then the light should be <expected_state>

    Examples:
      | initial_state | action | expected_state |
      | "off"         | "on"   | "on"           |
      | "on"          | "on"   | "on"           |
      | "off"         | "off"  | "off"          |
      | "on"          | "off"  | "off"          |
