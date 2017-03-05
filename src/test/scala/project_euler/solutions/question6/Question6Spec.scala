package project_euler.solutions.question6

import org.scalatest._


class Question6Spec extends FlatSpec with Matchers {

  behavior of "the diffSumSquaresSquareSum function"

  it should  "return 2640 for range 1 to 10" in {
    diffSumSquaresSquareSum(1 to 10) shouldBe 2640
  }

}
