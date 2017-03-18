package project_euler.solutions

import scala.math.sqrt


package object question12 {

  lazy val triangularNumbers = Stream.from(2).scanLeft(1)(_ + _)

  def factorsOf(n : Int) : Set[Int] = {

    (1 to sqrt(n).toInt)
      .foldLeft(Set[Int]())(
        (factors, i) =>
          if (n % i == 0) factors + (i, n / i)
          else factors
      )
  }

  def firstTriangularWithMoreFactorsThan(n : Int) = {

    triangularNumbers
      .filter(factorsOf(_).size > n)
      .head
  }

}
