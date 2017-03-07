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

  "solution 4" should  "get result 906609" in {
    Question4Solution.result shouldBe "906609"
  }

  "solution 5" should  "get result 232792560" in {
    Question5Solution.result shouldBe "232792560"
  }

  "solution 6" should "get result 25164150" in {
    Question6Solution.result shouldBe "25164150"
  }

  "solution 7" should "get result 104743" in {
    Question7Solution.result shouldBe "104743"
  }

  "solution 8" should "get result 23514624000" in {
    Question8Solution.result shouldBe "23514624000"
  }

  "solution 9" should "get result 31875000" in {
    Question9Solution.result shouldBe "31875000"
  }

}
