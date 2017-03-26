package project_euler.solutions

import project_euler.resource_handling.getResourceLines


package object question8 {

  lazy val numberParts = getResourceLines("question8", "number_parts.txt")

  def productNumericChars(s : String) : BigInt = {

    s.map((c : Char) => BigInt(c.asDigit)).product
  }

  private lazy val number = numberParts.mkString("")

  def largestProductInSeriesOfLength(n : Int) : BigInt = {

    (1 until (number.length - n))
      .map(pos => number.slice(pos, pos + n))
      .map(productNumericChars)
      .max
  }

}
