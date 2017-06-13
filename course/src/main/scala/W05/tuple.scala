
def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
  case (Nil, x) => x
  case (x, Nil) => x
  case (x :: xs1, y :: ys1) =>
    if (x < y) {
      x :: merge(xs1, ys)
    } else {
      y :: merge(xs, ys1)
    }
}
