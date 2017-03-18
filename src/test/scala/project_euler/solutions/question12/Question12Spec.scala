package project_euler.solutions.question12

import org.scalatest.{FunSpec, Matchers}


class Question12Spec extends FunSpec with Matchers {

  describe("triangularNumbers") {

    it("should return first ten values correctly") {
      triangularNumbers.take(10).toList shouldBe List(1, 3, 6, 10, 15, 21, 28, 36, 45, 55)
    }

  }

  describe("factorsOf") {

    it("should return correct factors for 1") {
      factorsOf(1) shouldBe Set(1)
    }

    it("should return correct factors for 3") {
      factorsOf(3) shouldBe Set(1, 3)
    }

    it("should return correct factors for 6") {
      factorsOf(6) shouldBe Set(1, 2, 3, 6)
    }

    it("should return correct factors for 10") {
      factorsOf(10) shouldBe Set(1, 2, 5, 10)
    }

    it("should return correct factors for 15") {
      factorsOf(15) shouldBe Set(1, 3, 5, 15)
    }

    it("should return correct factors for 21") {
      factorsOf(21) shouldBe Set(1, 3, 7, 21)
    }

    it("should return correct factors for 25") {
      factorsOf(25) shouldBe Set(1, 5, 25)
    }

    it("should return correct factors for 28") {
      factorsOf(28) shouldBe Set(1, 2, 4, 7, 14, 28)
    }

  }

  describe("firstTriangularWithMoreFactorsThan") {

    it("should return 28 as first triangular number with more than 5 divisors") {
      firstTriangularWithMoreFactorsThan(5) shouldBe 28
    }

  }

}
