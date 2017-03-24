package project_euler.solutions

import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.tagobjects.Slow


class SolutionsSpec extends FlatSpec with Matchers {

  val nonSlowTestCases = Map(
    Question1Solution -> "233168",
    Question2Solution -> "4613732",
    Question3Solution -> "6857",
    Question4Solution -> "906609",
    Question5Solution -> "232792560",
    Question6Solution -> "25164150",
    Question8Solution -> "23514624000",
    Question9Solution -> "31875000",
    Question11Solution -> "70600674",
    Question12Solution -> "76576500",
    Question13Solution -> "5537376230",
    Question14Solution -> "837799",
    Question17Solution -> "21124"
  )

  for ((solution, expectedResult) <- nonSlowTestCases) {

    s"solution ${solution.questionNumber}" should s"get result $expectedResult" in {
      solution.result shouldBe expectedResult
    }

  }

  "solution 7" should "get result 104743" taggedAs Slow in {
    Question7Solution.result shouldBe "104743"
  }

  "solution 10" should "get result 142913828922" taggedAs Slow in {
    Question10Solution.result shouldBe "142913828922"
  }

}
