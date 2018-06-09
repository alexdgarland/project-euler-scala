package project_euler.solutions.question603

import org.scalatest.{FunSpec, Matchers}


class Question603Spec extends FunSpec with Matchers {

  describe("sumContiguousIntegerSubstrings function") {

    it("should return expected sum") {
      sumContiguousIntegerSubstrings(2024) shouldBe 2304
    }

  }

}