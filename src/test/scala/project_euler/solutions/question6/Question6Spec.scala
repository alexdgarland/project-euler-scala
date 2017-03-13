package project_euler.solutions.question6

import org.scalatest.{FunSpec, Matchers}

class Question6Spec extends FunSpec with Matchers {

  describe("the diffSumSquaresSquareSum function") {

    it("should return 2640 for range 1 to 10") {
      diffSumSquaresSquareSum(1 to 10) shouldBe 2640
    }

  }

}
