
val romanNumeral = Map(
  "I" -> 1,
  "V" -> 5,
  "X" -> 10
)

val capitalsOfCountry = Map(
  "US" -> "Washington",
  "France" -> "Paris"
)

def showCapitalOfCountry(country: String): String = capitalsOfCountry get country match {
  case None => "showCapitalOfCountry.None"
  case Some(_) => _
}
