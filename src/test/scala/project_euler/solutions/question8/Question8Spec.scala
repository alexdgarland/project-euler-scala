package project_euler.solutions.question8

import org.scalatest._


class Question8Spec extends FlatSpec with Matchers {

  behavior of "productNumericChars function"

  it should "multiply numeric chars in an example string properly" in {
    productNumericChars("1234") shouldBe 24
  }

  behavior of "the longestProductInSeriesOfLength function"

  it should  "calculate correctly for length 4" in {
    largestProductInSeriesOfLength(4) shouldBe 5832
  }

}
