import W04.{Number, Expr, Sum}

def show(e: Expr): String = e match {
  case Number(n) => n.toString
  case Sum(left, right) => show(left) + "+" + show(right)
}

show(Sum(Number(4), Number(6)))
