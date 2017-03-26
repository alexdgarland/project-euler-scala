package project_euler.solutions

import scala.math.pow


package object question6 {

  def diffSumSquaresSquareSum(range : Range) : Int = {

    val squareOfSum = pow(range.sum, 2)
    val sumOfSquares = range.map(pow(_, 2)).sum
    (squareOfSum - sumOfSquares).toInt
  }

}
