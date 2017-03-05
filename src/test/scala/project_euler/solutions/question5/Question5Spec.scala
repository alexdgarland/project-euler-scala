package project_euler.solutions.question5

import org.scalatest._


class Question5Spec extends FlatSpec with Matchers {

  behavior of "the smallestCommonMultiple function"

  it should  "return 2520 for range 1 to 10" in {
    smallestCommonMultiple(1 to 10) shouldBe 2520
  }

}
