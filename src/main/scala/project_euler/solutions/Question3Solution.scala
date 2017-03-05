package project_euler.solutions

import project_euler.solutions.question3.primeFactors

object Question3Solution extends Solution {

  override def questionNumber = 3

  override def questionTitle = "Largest prime factor"

  override def questionBody =
    """
    |The prime factors of 13195 are 5, 7, 13 and 29.
    |What is the largest prime factor of the number 600851475143 ?
    |""".stripMargin

  override def result = primeFactors(BigInt("600851475143")).max.toString

}
