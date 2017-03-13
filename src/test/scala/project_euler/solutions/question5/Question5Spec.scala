package project_euler.solutions.question5

import org.scalatest.{FunSpec, Matchers}

class Question5Spec extends FunSpec with Matchers {

  describe("the smallestCommonMultiple function") {

    it("should return 2520 for range 1 to 10") {
      smallestCommonMultiple(1 to 10) shouldBe 2520
    }

  }

}
