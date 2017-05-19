package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    def factorial(x: Int): Int = {
      def loop (acc: Int, n: Int): Int = {
        if (n == 0) acc
        else loop(acc * n, n - 1)
      }

      loop(1, x)
    }

    factorial(r) / (factorial(c) * factorial(r - c))
  }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = ???
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
