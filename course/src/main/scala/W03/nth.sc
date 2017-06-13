import W03.{List, Cons, Nil}

def nth[T](index: Int, xs: List[T]): T = {
  if (index == 0) {
    xs.head
  } else {
    nth(index - 1, xs.tail)
  }
}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth(2, list)
