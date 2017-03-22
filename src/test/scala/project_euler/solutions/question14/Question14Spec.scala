package project_euler.solutions.question14

import org.scalatest.{FunSpec, Matchers}


class Question14Spec extends FunSpec with Matchers {

  describe("collatzSeq function") {

    it("returns immediately when sequence starts with 1") {
      collatzSeq(1) shouldBe List(1)
    }

    it("returns correct sequence for starting value 13 with no explicit input map") {
      collatzSeq(13) shouldBe List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
    }

    it("returns correct sequence for starting value 13 with input map provided") {
      val expected = List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
      val inputMap = Map(BigInt(10) -> List[BigInt](10, 5, 16, 8, 4, 2, 1))
      collatzSeq(13, Some(inputMap)) shouldBe expected
    }

  }

  describe("collatzSeqsUnder function") {

    it("returns correct map of sequences for starting points between 1 and 5") {

      val expected = Map(
        1 -> List(1),
        2 -> List(2, 1),
        3 -> List(3, 10, 5, 16, 8, 4, 2, 1),
        4 -> List(4, 2, 1),
        5 -> List(5, 16, 8, 4, 2, 1)
      )

      collatzSeqsUnder(6) shouldBe expected
    }

  }

  describe("longestCollatzUnder function") {

    it("should return 3 for starting points between 1 and 5") {
      longestCollatzUnder(6) shouldBe 3
    }
  }

}
