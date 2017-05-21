def nonTailFactorial(x: Int): Int =
  if (x == 0) 0 else x * nonTailFactorial(x - 1)

def factorial(x: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else loop(acc * n, n - 1)

  loop(1, x)
}

nonTailFactorial(2)
factorial(2)
