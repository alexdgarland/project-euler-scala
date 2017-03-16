package project_euler.solutions

import question8.{numberParts, largestProductInSeriesOfLength}


object Question8Solution extends Solution {

  override def questionNumber = 8

  override def questionTitle = "Largest product in a series"

  override def questionBody =
    s"""
       |The four adjacent digits in the 1000-digit number that have the greatest product are 9 * 9 * 8 * 9 = 5832.
       |
    |${numberParts.mkString("\n")}
       |
    |Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?
       |""".stripMargin

  override def result = largestProductInSeriesOfLength(13).toString

}



