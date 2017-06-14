
def isPrime(n: Int): Boolean = {
  2.until(n).forall(n % _ != 0)
}

val n = 7

1.until(n)
  .flatMap(i => 1.until(i).map(j => (i, j)))
  .filter{ case (x, y) => isPrime(x + y) }

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

def scalarProductsWithZip(xs: List[Double], ys: List[Double]): Double = {
  (for ((x, y) <- xs.zip(ys)) yield x * y).sum
}

