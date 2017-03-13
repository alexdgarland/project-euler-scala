package project_euler.solutions.question11

import org.scalatest.{FunSpec, Matchers}


class Question11Spec extends FunSpec with Matchers {

  val testGrid = List(
    List(1, 2, 3, 4),
    List(5, 6, 7, 8),
    List(9, 10, 11, 12),
    List(13, 14, 15, 16)
  )

  describe("verticalLinesOfSize function") {

    it("should return expected lines of size 3 against test grid") {

      val expectedResult = IndexedSeq(
        IndexedSeq(1, 5, 9), IndexedSeq(5, 9, 13),
        IndexedSeq(2, 6, 10), IndexedSeq(6, 10, 14),
        IndexedSeq(3, 7, 11), IndexedSeq(7, 11, 15),
        IndexedSeq(4, 8, 12), IndexedSeq(8, 12, 16)
      )

      verticalLinesOfSize(3, testGrid) shouldBe expectedResult
    }

  }

  describe("horizontalLinesOfSize function") {

    it("should return expected lines of size 3 against test grid") {

      val expectedResult = IndexedSeq(
        IndexedSeq(1, 2, 3), IndexedSeq(2, 3, 4),
        IndexedSeq(5, 6, 7), IndexedSeq(6, 7, 8),
        IndexedSeq(9, 10, 11), IndexedSeq(10, 11,12),
        IndexedSeq(13, 14, 15), IndexedSeq(14, 15, 16)
      )

      horizontalLinesOfSize(3, testGrid) shouldBe expectedResult
    }

  }

  describe("forwardDiagonalLinesOfSize function") {

    ignore("should return expected lines of size 3 against test grid") {

      val expectedResult = IndexedSeq(
        IndexedSeq(9, 6, 3), IndexedSeq(10, 7, 4),
        IndexedSeq(13, 10, 7), IndexedSeq(14, 11, 8)
      )

      forwardDiagonalLinesOfSize(3, testGrid) shouldBe expectedResult
    }

  }

  describe("backwardDiagonalLinesOfSize function") {

    ignore("should return expected lines of size 3 against test grid") {

      val expectedResult = IndexedSeq(
        IndexedSeq(1, 6, 11), IndexedSeq(2, 7, 12),
        IndexedSeq(5, 10, 15), IndexedSeq(6, 11, 16)
      )

      backwardDiagonalLinesOfSize(3, testGrid) shouldBe expectedResult
    }

  }

}
