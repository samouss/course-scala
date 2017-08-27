object Loops {
  var count = 0
  var value = 0

  def REPEAT(command: => Unit)(condition: => Boolean): Unit = {
    command

    if (condition) {}
    else {
      REPEAT(command)(condition)
    }
  }

  def run(): Unit = {
    REPEAT({
      value = value + 5
      count = count + 1

      println(value)
    })(count >= 5)
  }
}
