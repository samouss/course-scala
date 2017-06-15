class Rational(x: Int, y: Int) {
  def numer: Int = x
  def denom: Int = y
}

object Rationals {
  val x = new Rational(1, 2)

  x.numer
  x.denom
}
