package project_euler.solutions

import scala.math.pow

package object question603 {

  // Implements S(n), such that:
  // Let S(n) be the sum of all contiguous integer-substrings that can be formed from the integer n.
  // The substrings need not be distinct.
  // For example, S(2024) = 2 + 0 + 2 + 4 + 20 + 02 + 24 + 202 + 024 + 2024 = 2304.
  def sumContiguousIntegerSubstrings(n : Int) : Int = {

    def contiguousSubstrings(s : String) : List[List[String]] = {
      if(s.length == 1) {
        List(List(s))
      }
      else {
        val tailLists = contiguousSubstrings(s.tail)
        val current = s.head.toString :: tailLists.head.map(s.head + _)
        current :: tailLists
      }
    }

    contiguousSubstrings(n.toString).flatMap(_.map(_.toInt)).sum
  }

  private val MODULUS =  pow(10, 9).toInt + 7


}
