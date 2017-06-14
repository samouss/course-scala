
def squareListRecursive(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => (y * y) :: squareListRecursive(ys)
}

def squareListMap(xs: List[Int]): List[Int] = {
  xs.map(x => x * x)
}

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case y :: _ =>
    val (first, rest) = xs.span(x => x == y)
    first :: pack(rest)
}

def encode[T](xs: List[T]): List[(T, Int)] = {
  pack(xs).map(ys => (ys.head, ys.length))
}
