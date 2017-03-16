package project_euler.solutions.question10

import org.scalatest.{FunSpec, Matchers}


class Question10Spec extends FunSpec with Matchers {

  describe("primesBelow function") {

    it("should return empty vector for primes below 2") {
      primesBelow(2) shouldBe Vector.empty[Int]
    }

    it("should return expected vector for primes below 10") {
      primesBelow(10) shouldBe Vector(2, 3, 5, 7)
    }

  }

}
