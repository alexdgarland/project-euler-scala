package project_euler.solutions

import question7.nthPrime

object Question7Solution extends Solution {

  override def questionNumber = 7

  override def questionTitle = "10001st prime"

  override def questionBody =
    """
    |By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    |What is the 10,001st prime number?
    |""".stripMargin

  override def result = nthPrime(10001).toString

}



