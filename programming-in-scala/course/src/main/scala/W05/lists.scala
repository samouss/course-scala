
def init[T](xs: List[T]): List[T] = xs match {
  case Nil => throw new Error("init of empty list")
  case _ :: Nil => Nil
  case y :: ys => y :: init(ys)
}

def reverse[T](xs: List[T]): List[T] = xs match {
  case Nil => xs
  case y :: ys => reverse(ys) ::: List(y)
}

def removeAt[T](n: Int, xs: List[T]): List[T] = {
  xs.take(n) ::: xs.drop(n + 1)
}
