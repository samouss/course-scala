package W01

object Generators {

  trait Generator[+T] {
    self =>

    def generate: T

    def map[U](f: T => U): Generator[U] = new Generator[U] {
      def generate: U = f(self.generate)
    }

    def flatMap[U](f: T => Generator[U]): Generator[U] = new Generator[U] {
      def generate: U = f(self.generate).generate
    }
  }

  val integers = new Generator[Int] {
    val rand = new java.util.Random
    def generate: Int = rand.nextInt
  }

  val booleans = new Generator[Boolean] {
    def generate: Boolean = integers.generate > 0
  }

  // ==

  val booleans2 = for (x <- integers) yield x > 0

  val pairs = new Generator[(Int, Int)] {
    def generate: (Int, Int) = (integers.generate, integers.generate)
  }

  def single[T](x: T): Generator[T] = new Generator[T] {
    def generate: T = x
  }

  def choose(low: Int, high: Int): Generator[Int] = {
    for (x <- integers) yield low + x % (high - low)
  }

  def oneOf[T](xs: T*): Generator[T] = {
    for (idx <- choose(0, xs.length)) yield xs(idx)
  }

  def test[T](g: Generator[T], times: Int = 100)(test: T => Boolean): Unit = {
    for (_ <- 0 until times) {
      val value = g.generate

      assert(test(value), "Test failed for value: " + value)
    }

    println("All test passed")
  }

}
