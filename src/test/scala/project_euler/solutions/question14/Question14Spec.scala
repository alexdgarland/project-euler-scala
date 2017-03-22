package project_euler.solutions.question14

import org.scalatest.{FunSpec, Matchers}


class Question14Spec extends FunSpec with Matchers {

  describe("collatzSequenceFrom function") {

    it("returns immediately when sequence starts with 1") {
      collatzSequenceFrom(1) shouldBe List(1)
    }

    it("returns correct sequence for starting value 13") {
      val expected = List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
      collatzSequenceFrom(13) shouldBe expected
    }

  }

  describe("longestCollatzUnder function") {

    it("should return 3 for starting points between 1 and 5") {
      longestCollatzUnder(6) shouldBe 3
    }
  }

}
