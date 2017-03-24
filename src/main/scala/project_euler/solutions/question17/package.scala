package project_euler.solutions

package object question17 {

  private val onesParts = Map(
    0 -> "",
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine"
  )

  private val tensParts = Map(
    0 -> "",
    2 -> "twenty",
    3 -> "thirty",
    4 -> "forty",
    5 -> "fifty",
    6 -> "sixty",
    7 -> "seventy",
    8 -> "eighty",
    9 -> "ninety"
  )

  private val teenSpecialCases = Map(
    10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen"
  )

  private def concatWithSeparator(a : String, sep : String, b : String) = {

    List(a, b).filter(_ != "").mkString(sep)
  }

  private def onesPart(i : Int) = onesParts(i % 10)

  private def tensAndOnesPart(i : Int) : String = {

    if (i < 10)
      onesPart(i)
    else if (i < 20)
      teenSpecialCases(i)
    else
      concatWithSeparator(tensParts(i / 10), " ", onesPart(i))
  }

  private def hundredsPart(i : Int) = i / 100 match {
    case 0 =>
      ""
    case 10 =>
      "one thousand"
    case n =>
      s"${onesPart(n)} hundred"
  }

  def stringRepresentation(i : Int) : String = {

    concatWithSeparator(hundredsPart(i), " and ", tensAndOnesPart(i % 100))
  }

  def characterCount(i : Int) : Int = {

    stringRepresentation(i).replaceAll(" ", "").length
  }

}
