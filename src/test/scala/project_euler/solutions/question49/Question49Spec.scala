package project_euler.solutions.question49

import org.scalatest.{FunSpec, Matchers}

import scala.collection.SortedSet

class Question49Spec extends FunSpec with Matchers {

  describe("ascendingCombinations function") {

    it("should return expected ascending combinations") {
      val expectedList = List(Set(1, 2, 3), Set(1, 2, 4), Set(1, 3, 4), Set(2, 3, 4))
      ascendingCombinations(SortedSet(1, 2, 3, 4)) shouldBe expectedList
    }

    it("should return expected ascending combinations with 5 inputs") {
      val expectedList = List(
        Set(1, 2, 3), Set(1, 2, 4), Set(1, 2, 5),
        Set(1, 3, 4), Set(1, 3, 5),
        Set(1, 4, 5),
        Set(2, 3, 4), Set(2, 3, 5),
        Set(2, 4, 5),
        Set(3, 4, 5)
      )
      ascendingCombinations(SortedSet(1, 2, 3, 4, 5)) shouldBe expectedList
    }

  }

  describe("getUniquePermutations function") {

    it("return permutations where digits are unique") {
      val expectedList = SortedSet(
        1234, 1243, 1324, 1342, 1423, 1432,
        2134, 2143, 2314, 2341, 2413, 2431,
        3124, 3142, 3214, 3241, 3412, 3421,
        4123, 4132, 4213, 4231, 4312, 4321
      )
      uniquePermutations(1234) shouldBe expectedList
    }

    it("return only unique permutations where digits are not unique") {
      val expectedList = SortedSet(
        1123, 1132, 1213,
        1231, 1312, 1321,
        2113, 2131, 2311,
        3112, 3121, 3211
      )
      uniquePermutations(1123) shouldBe expectedList
    }

  }

}