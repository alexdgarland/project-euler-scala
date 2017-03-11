package project_euler.solutions.question10

import org.scalatest._


class Question10Spec extends FlatSpec with Matchers {

  behavior of "primesBelow function"

  it should "return empty vector for primes below 2" in {
    primesBelow(2) shouldBe Vector.empty[Int]
  }

  it should "return expected vector for primes below 10" in {
    primesBelow(10) shouldBe Vector(2, 3, 5, 7)
  }

}
