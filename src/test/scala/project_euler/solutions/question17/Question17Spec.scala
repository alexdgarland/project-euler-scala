package project_euler.solutions.question17

import org.scalatest.{FunSpec, Matchers}


class Question17Spec extends FunSpec with Matchers {

  describe("getStringRepresentation function") {

    val testCases = Map(
      1 -> "one",
      7 -> "seven",
      10 -> "ten",
      11 -> "eleven",
      15 -> "fifteen",
      19 -> "nineteen",
      20 -> "twenty",
      27 -> "twenty seven",
      100 -> "one hundred",
      127 -> "one hundred and twenty seven",
      500 -> "five hundred",
      510 -> "five hundred and ten",
      582 -> "five hundred and eighty two",
      1000 -> "one thousand"
    )

    for ((input, expectedString) <- testCases) {

      it(s"returns correct string for $input") {
        stringRepresentation(input) shouldBe expectedString
      }

    }

  }

}
