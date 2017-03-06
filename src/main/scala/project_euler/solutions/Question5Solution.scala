package project_euler.solutions

import question5.smallestCommonMultiple

object Question5Solution extends Solution {

  override def questionNumber = 5

  override def questionTitle = "Smallest multiple"

  override def questionBody =
    """
    |2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    |What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    |""".stripMargin

  override def result = smallestCommonMultiple(1 to 20).toString

}
