package project_euler.solutions.question3

import org.scalatest.{FunSpec, Matchers}


class Question3Spec extends FunSpec with Matchers {

  describe("the primeFactors function") {

    it("should get correct set of factors") {
      primeFactors(BigInt(13195)) shouldBe Set(5, 7, 13, 29).map(BigInt(_))
    }

    it("should return only a single element for powers of the same prime factor") {
      primeFactors(BigInt(8)) shouldBe Set(2)
    }

  }

}
