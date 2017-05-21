import org.scalatest._
import java.time.LocalDate

class TaskManagerSpec extends FlatSpec with Matchers {

  "An empty tasks list" should "have 0 tasks due today" in {
    val expectation = 0
    val actual = TaskManager.allTasksDueToday(List())

    actual should have length expectation
  }

  "A task list with one task due today" should "have 1 task due today" in {
    val t1 = Task("Write blog on SBT", LocalDate.now(), Seq("blogging"))
    val t2 = Task("Write a factorial program", LocalDate.now().plusDays(1), Seq("coding"))

    val expectation = 1
    val actual = TaskManager.allTasksDueToday(List(t1, t2))

    actual should have length expectation
  }

}
