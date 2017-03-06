package project_euler.solutions

import question4.maxPalindromeProduct

object Question4Solution extends Solution {

  override def questionNumber = 4

  override def questionTitle = "Largest palindrome product"

  override def questionBody =
    """
    |A palindromic number reads the same both ways.
    |The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    |Find the largest palindrome made from the product of two 3-digit numbers.
    |""".stripMargin

  override def result = maxPalindromeProduct(1 to 999).toString

}
