package project_euler.solutions

import project_euler.solutions.question13._


object Question13Solution extends Solution {

  override def questionNumber = 13

  override def questionTitle = "Large sum"

  override def questionBody = {

    val numbers = fiftyDigitStrings
      .map(number => s"    $number")
      .mkString("\n")

    s"""
       |  Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
       |
       |$numbers
       |
       |""".stripMargin

  }

  override def result = {

    val sumAsParts =
      fiftyDigitStrings
        .map(stringToParts)
        .reduce(addParts)

    partsToString(sumAsParts).take(10)
  }

}
