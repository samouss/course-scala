import math.Ordering

def merge[T](xs: List[T], ys: List[T])(implicit ord: Ordering[T]): List[T] = (xs, ys) match {
  case (Nil, x) => x
  case (x, Nil) => x
  case (x :: xs1, y :: ys1) =>
    if (ord.lt(x, y)) {
      x :: merge(xs1, ys)
    } else {
      y :: merge(xs, ys1)
    }
}

def mergeSort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
  val n = xs.length / 2

  if (n == 0) {
    xs
  } else {
    val (fst, snd) = xs splitAt n

    merge(mergeSort(fst), mergeSort(snd))
  }
}
