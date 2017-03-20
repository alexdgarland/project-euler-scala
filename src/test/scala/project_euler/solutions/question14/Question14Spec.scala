package project_euler.solutions.question14

import org.scalatest.{FunSpec, Matchers}


class Question14Spec extends FunSpec with Matchers {

  describe("collatzSequence function") {

    it("returns correct sequence for starting value 13") {
      collatzSequence(13) shouldBe Stream(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
    }

  }

}
