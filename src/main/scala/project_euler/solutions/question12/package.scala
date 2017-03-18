package project_euler.solutions

import scala.math.sqrt


package object question12 {

  lazy val triangularNumbers = Stream.from(2).scanLeft(1)(_ + _)

  def factorsOf(n : Int) : Set[Int] = {

    val root = sqrt(n).toInt

    def recurse(i : Int, factors : Set[Int]) : Set[Int] = {

      if (i > root) factors
      else if (n % i == 0) recurse(i + 1, factors + (i, n / i))
      else recurse(i + 1, factors)
    }

    recurse(1, Set())
  }

  def firstTriangularWithMoreFactorsThan(n : Int) = {

    triangularNumbers
      .filter(factorsOf(_).size > n)
      .head
  }

}
