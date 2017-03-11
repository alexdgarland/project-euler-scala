package project_euler.solutions

import project_euler.solutions.question10.primesBelow

object Question10Solution extends Solution {

  override def questionNumber = 10

  override def questionTitle = "Summation of primes"

  override def questionBody =
    s"""
    |The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    |Find the sum of all the primes below two million.
    |""".stripMargin

  override def result = primesBelow(2000000).map(BigInt(_)).sum.toString

}
