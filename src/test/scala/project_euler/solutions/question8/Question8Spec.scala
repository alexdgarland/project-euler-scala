package project_euler.solutions.question8

import org.scalatest.{FunSpec, Matchers}


class Question8Spec extends FunSpec with Matchers {

  describe("productNumericChars function") {

    it("should multiply numeric chars in an example string properly") {
      productNumericChars("1234") shouldBe 24
    }

  }

  describe("the longestProductInSeriesOfLength function") {

    it("should calculate correctly for length 4") {
      largestProductInSeriesOfLength(4) shouldBe 5832
    }

  }

}
