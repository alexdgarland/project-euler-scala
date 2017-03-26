package project_euler.solutions

import project_euler.solutions.question11._


object Question11Solution extends Solution {

  override def questionNumber = 11

  override def questionTitle = "Largest product in a grid"

  override def questionBody =
    s"""
       |In the 20×20 grid below, four numbers along a diagonal line have been marked in red.
       |
       |${gridFileLines.mkString("\n")}
       |
       |The product of these numbers is 26 * 63 * 78 * 14 = 1788696.
       |
       |What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
       |""".stripMargin

  override def result = {

    gridTransitions
      .flatMap(getLines(questionGrid, 4, _))
      .map(_.product)
      .max
      .toString

  }

}
