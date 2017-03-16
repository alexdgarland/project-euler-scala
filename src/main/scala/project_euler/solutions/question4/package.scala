package project_euler.solutions

import scala.annotation.tailrec


package object question4 {

  @tailrec
  def isPalindrome(s : String) : Boolean = {

    if (s.length < 2) true
    else if (s.head != s.last) false
    else isPalindrome(s.slice(1, s.length - 1))
  }

  def maxPalindromeProduct(inputRange : Range) : Int = {

    (
      for {
        x <- inputRange
        y <- inputRange
      } yield x * y
      )
      .filter(i => isPalindrome(i.toString))
      .max
  }

}
