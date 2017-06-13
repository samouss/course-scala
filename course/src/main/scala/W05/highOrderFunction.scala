
def squareListRecursive(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => (y * y) :: squareListRecursive(ys)
}

def squareListMap(xs: List[Int]): List[Int] = {
  xs.map(x => x * x)
}
