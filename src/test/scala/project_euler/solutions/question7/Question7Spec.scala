package project_euler.solutions.question7

import org.scalatest._


class Question7Spec extends FlatSpec with Matchers {

  behavior of "the nthPrime function"

  it should  "identify 13 as the 6th prime" in {

    nthPrime(6) shouldBe 13
  }

}
