package project_euler.solutions

import java.nio.file.Paths


package object question13 {

  lazy val fiftyDigitStrings : List[String] = {

    val path = Paths.get("question13", "fifty_digit_numbers.txt")

    scala.io.Source
      .fromResource(path.toString)
      .getLines
      .toList
  }

  def stringToParts(s : String) : List[BigInt] = {

    // Very simple parsing into 10-digit chunks which can easily be represented as BigInt's -
    // we know all input strings are exactly 50 numeric characters.
    val parsed = (0 to 40 by 10).map(i => BigInt(s.slice(i, i + 10)))
    // Pad to 6 rather than 5 groups of 10 digits for consistency once we start adding up.
    BigInt(0) :: parsed.toList
  }

  def partsToString(parts : List[BigInt]) : String = {

    def formatPart(i : BigInt, s : String) =
      if (s != "") "%010d".format(i)
      else if (i == 0) ""
      else i.toString

    parts.foldLeft("")((s, i) => s + formatPart(i, s))
  }

  def addParts(parts1 : List[BigInt], parts2 : List[BigInt]) : List[BigInt] = {

    // Add using a simple carry mechanism

    val base = BigInt("10000000000")

    case class State(list : List[BigInt] = Nil, carry : BigInt = 0)

    def deriveNewState(numbers : (BigInt, BigInt), state : State) = {

      val sum = numbers._1 + numbers._2 + state.carry

      if (sum >= base)
        State((sum - base) :: state.list, carry = 1)
      else
        State(sum :: state.list)
    }

    parts1
      .zip(parts2)
      .foldRight(State())(deriveNewState)
      .list
  }

}
