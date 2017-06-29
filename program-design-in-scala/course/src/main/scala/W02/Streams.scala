package W02

object Streams {
  val xs = Stream.cons(1, Stream.cons(2, Stream.empty))
  val ys = Stream(1, 2)

  def streamRange(low: Int, high: Int): Stream[Int] = {
    if (low >= high) {
      Stream.empty
    } else {
      low #:: streamRange(low + 1, high)
    }
  }

  def listRange(low: Int, high: Int): List[Int] = {
    if (low >= high) {
      Nil
    } else {
      low :: listRange(low + 1, high)
    }
  }
}
