import java.time.LocalDate

case class Task(title: String, dueDate: LocalDate, tags: Seq[String] = Seq(), done: Boolean = false)
