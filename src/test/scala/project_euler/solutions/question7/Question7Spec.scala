package project_euler.solutions.question7

import org.scalatest.{FunSpec, Matchers}

class Question7Spec extends FunSpec with Matchers {

  describe("the nthPrime function") {

    it("should identify 13 as the 6th prime") {
      nthPrime(6) shouldBe 13
    }

  }

}
