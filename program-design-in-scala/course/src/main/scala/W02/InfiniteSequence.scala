package W02

object InfiniteSequence {
  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }
}
