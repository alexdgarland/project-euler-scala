package project_euler.solutions

import scala.math.pow

package object question9 {

  case class Triplet(a : Int, b : Int, c : Int) {

    def product  : Int = a * b * c

    def isPythagorean : Boolean = {
      a < b &&
        b < c &&
        pow(a, 2) + pow(b, 2) == pow(c, 2)
    }

  }

  def tripletsSummingTo(n : Int) : IndexedSeq[Triplet]= {
    (1 to (n - 2))
      .flatMap(
        a =>
          (1 to (n - (a + 1)))
            .map(
              b =>
                Triplet(a, b, n - (a + b))
            )
      )
  }

}
