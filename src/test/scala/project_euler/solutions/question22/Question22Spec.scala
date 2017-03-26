package project_euler.solutions.question22

import org.scalatest.{FunSpec, Matchers}


class Question22Spec extends FunSpec with Matchers {

  describe("sortedNamesWithIndex") {

    it("has expected element at 938th position") {
      sortedNamesWithIndex(937) shouldBe(938, "COLIN")
    }

  }

  describe("nameValue function") {

    it("returns 53 for name \"COLIN\"") {
      nameValue("COLIN") shouldBe 53
    }

  }

  describe("getTotalValueOfSortedNames function") {

    it("sums example list correctly") {

      val exampleList = List(
        (1, "AARON"), // 49 * 1
        (2, "ABBEY"), // 35 * 2
        (3, "ABBIE")  // 19 * 3
      )

      getTotalValueOfSortedNames(exampleList) shouldBe 176

    }

  }

}
