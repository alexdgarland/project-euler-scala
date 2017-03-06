package project_euler.solutions.question3

import org.scalatest._

class Question3Spec extends FlatSpec with Matchers {

  behavior of "the primeFactors function"

  it should "get correct set of factors" in {
    primeFactors(BigInt(13195)) shouldBe Set(5, 7, 13, 29).map(BigInt(_))
  }

  it should "return only a single element for powers of the same prime factor" in {
    primeFactors(BigInt(8)) shouldBe Set(2)
  }

}
