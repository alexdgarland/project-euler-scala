package project_euler.solutions

import question9.tripletsSummingTo

object Question9Solution extends Solution {

  override def questionNumber = 9

  override def questionTitle = "Special Pythagorean triplet"

  override def questionBody =
    s"""
    |A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    |   a2 + b2 = c2
    |For example, 32 + 42 = 9 + 16 = 25 = 52.
    |
    |There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    |Find the product abc.
    |""".stripMargin

  override def result = tripletsSummingTo(1000).filter(_.isPythagorean).head.product.toString

}



