package project_euler.solutions

import org.scalatest._


class SolutionsSpec extends FlatSpec with Matchers {

  "solution 1" should  "get result 233168" in {
    Question1Solution.result shouldBe "233168"
  }

  "solution 2" should  "get result 4613732" in {
    Question2Solution.result shouldBe "4613732"
  }

  "solution 3" should  "get result 6857" in {
    Question3Solution.result shouldBe "6857"
  }

}
