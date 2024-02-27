package light

import io.cucumber.scala.{ScalaDsl, EN}

class LightDeviceSteps extends ScalaDsl with EN {

  private var lightDevice: LightDevice = _

  Given("I have a light device") {
    lightDevice = LightDevice()
  }

  And("the light is {string}") { (state: String) =>
    state match
      case "on" => lightDevice.turnOn()
      case "off" => lightDevice.turnOff()
  }

  When("I turn {string} the light") { (action: String) =>
    action match
      case "on" => lightDevice.turnOn()
      case "off" => lightDevice.turnOff()
  }

  Then("the light should be {string}") { (state: String) =>
    state match
      case "on" => assert(lightDevice.status() == Status.ON)
      case "off" => assert(lightDevice.status() == Status.OFF)
  }

}
