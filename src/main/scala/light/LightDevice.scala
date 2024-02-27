package light


trait LightDevice {

  def status(): Status

  def turnOn(): Unit

  def turnOff(): Unit
}

enum Status {
  case ON, OFF
}

object LightDevice {

  def apply(): LightDevice = new LightDeviceImpl()

  private class LightDeviceImpl extends LightDevice {
    private var statusImpl: Status = Status.OFF

    override def status(): Status = statusImpl

    override def turnOn(): Unit = statusImpl = Status.ON

    override def turnOff(): Unit = statusImpl = Status.OFF
  }
}
