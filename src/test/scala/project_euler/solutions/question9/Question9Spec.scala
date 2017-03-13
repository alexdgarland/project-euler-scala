package project_euler.solutions.question9

import org.scalatest.{FunSpec, Matchers}

class Question9Spec extends FunSpec with Matchers {

  describe("tripletsSummingTo function") {

    it("should produce expected triplets summing to 4") {
      val expected = IndexedSeq(Triplet(1, 1, 2), Triplet(1, 2, 1), Triplet(2, 1, 1))
      tripletsSummingTo(4) shouldBe expected
    }

  }

  describe("Triplet") {

    describe("isPythagorean method") {

      it("should identify a Pythagorean triplet") {
        Triplet(3, 4, 5).isPythagorean shouldBe true
      }

      it("should identify a triplet as non-Pythagorean based on ordering") {
        Triplet(4, 3, 5).isPythagorean shouldBe false
      }

      it("should identify a triplet as non-Pythagorean based on squares not summing") {
        Triplet(1, 2, 5).isPythagorean shouldBe false
      }

    }

    describe("product method") {

      it("should produce correct product") {
        Triplet(3, 4, 5).product shouldBe 60
      }

    }

  }

}
