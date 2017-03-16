package project_euler.solutions

object Question1Solution extends Solution {

  override def questionNumber = 1

  override def questionTitle = "Multiples of 3 and 5"

  override def questionBody =
    """
      |If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
      |The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
      |""".stripMargin

  override def result = Range(1, 1000).filter(i => (i % 3 == 0) || (i % 5 == 0)).sum.toString

}
