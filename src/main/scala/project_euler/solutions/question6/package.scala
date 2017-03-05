package project_euler.solutions

import scala.math.pow

package object question6 {

  def diffSumSquaresSquareSum(range : Range) : Int = {
    (pow(range.sum, 2) - range.map(pow(_, 2)).sum).toInt
  }

}
