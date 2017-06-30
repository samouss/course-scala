package W02

class Pouring(capacity: Vector[Int]) {

  // State
  type State = Vector[Int]

  val initialState = capacity.map(_ => 0)
  val initialPath = new Path(Nil, initialState)

  val glasses = capacity.indices

  val moves = {
    (for (g <- glasses) yield Empty(g)) ++
    (for (g <- glasses) yield Fill(g)) ++
    (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))
  }

  val pathSets = from(Set(initialPath), Set(initialState))

  // Moves
  trait Move {
    def change(state: State): State
  }

  case class Empty(glass: Int) extends Move {
    def change(state: State): State = state.updated(glass, 0)
  }

  case class Fill(glass: Int) extends Move {
    def change(state: State): State = state.updated(glass, capacity(glass))
  }

  case class Pour(from: Int, to: Int) extends Move {
    def change(state: State): State = {
      val amount = state(from).min(capacity(to) - state(to))

      state
        .updated(from, state(from) - amount)
        .updated(to, state(to) + amount)
    }
  }

  // Path
  class Path(history: List[Move], val endState: State) {
    def extend(move: Move): Path = new Path(move :: history, move.change(endState))

    override def toString: String = history.reverse.mkString(" ") + "--->" + endState
  }

  def from(paths: Set[Path], explored: Set[State]): Stream[Set[Path]] = {
    if (paths.isEmpty) {
      Stream.empty
    } else {
      val more = for {
        path <- paths
        next <- moves.map(path.extend)
        if !explored.contains(next.endState)
      } yield next

      paths #:: from(more, explored ++ more.map(_.endState))
    }
  }

  // Resolution
  def solution(target: Int): Stream[Path] = {
    for {
      pathSet <- pathSets
      path <- pathSet
      if path.endState.contains(target)
    } yield path
  }
}
