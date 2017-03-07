package project_euler.solutions.question9

import org.scalatest._

class Question9Spec extends FlatSpec with Matchers {

  behavior of "tripletsSummingTo function"

  it should "produce expected triplets summing to 4" in {
    tripletsSummingTo(4) shouldBe IndexedSeq(Triplet(1, 1, 2), Triplet(1, 2, 1), Triplet(2, 1, 1))
  }

  behavior of "Triplet isPythagorean method"

  it should "identify a Pythagorean triplet" in {
    Triplet(3, 4, 5).isPythagorean shouldBe true
  }

  it should "identify a triplet as non-Pythagorean based on ordering" in {
    Triplet(4, 3, 5).isPythagorean shouldBe false
  }

  it should "identify a triplet as non-Pythagorean based on squares not summing" in {
    Triplet(1, 2, 5).isPythagorean shouldBe false
  }

  behavior of "Triplet product method"

  it should "produce correct product" in {
    Triplet(3, 4, 5).product shouldBe 60
  }

}
