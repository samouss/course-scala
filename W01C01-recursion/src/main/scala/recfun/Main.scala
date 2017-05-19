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
  def balance(chars: List[Char]): Boolean = {
    def isNegative(x: Int): Boolean = x < 0

    def increment(char: Char, count: Int): Int =
      if (char == '(') count + 1 else count - 1

    def loop(chars: List[Char], count: Int = 0): Boolean = {
      if (isNegative(count)) false
      else chars match {
        case Nil => count == 0
        case x :: Nil => increment(x, count) == 0
        case x :: xs => loop(xs, increment(x, count))
      }
    }

    chars match {
      case _ if chars.length <= 1 => false
      case _ => loop(chars.filter(x => x == '(' || x == ')'))
    }
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
    coins match {
      case _ if money == 0 => 1
      case x :: xs if money > 0 => countChange(money - x, x :: xs) + countChange(money, xs)
      case _ => 0
    }
}
