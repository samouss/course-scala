package W01

object Monads {

  abstract class Option[+T] {

    def flatMap[U](f: T => Option[U]): Option[U] = this match {
      case None => None
      case Some(x) => f(x)
    }

  }

}
