package project_euler.solutions.question13

import org.scalatest.{FunSpec, Matchers}


class Question13Spec extends FunSpec with Matchers {

  describe("stringToParts function") {

    it("parse string to BigInt parts correctly") {
      val expected = List("0", "3223819573", "4329339946", "4375019078", "3694576588", "3352399886").map(BigInt(_))
      val actual = stringToParts("32238195734329339946437501907836945765883352399886")
      actual shouldBe expected
    }

  }

  describe("partsToString function") {

    it("reconstructs number with standard leading zero correctly") {
      val expected = "32238195734329339946437501907836945765883352399886"
      val input = List("0", "3223819573", "4329339946", "4375019078", "3694576588", "3352399886").map(BigInt(_))
      partsToString(input) shouldBe expected
    }

    it("reconstructs number with additional leading zero correctly") {
      val expected = "4329339946437501907836945765883352399886"
      val input = List("0", "0", "4329339946", "4375019078", "3694576588", "3352399886").map(BigInt(_))
      partsToString(input) shouldBe expected
    }

    it("reconstructs number with leading number less than ten digits correctly") {
      val expected = "2532238195734329339946437501907836945765883352399886"
      val input = List("25", "3223819573", "4329339946", "4375019078", "3694576588", "3352399886").map(BigInt(_))
      partsToString(input) shouldBe expected
    }

    it("reconstructs number with zero in middle correctly") {
      val expected = "32238195734329339946000000000036945765883352399886"
      val input = List("0", "3223819573", "4329339946", "0", "3694576588", "3352399886").map(BigInt(_))
      partsToString(input) shouldBe expected
    }

    it("reconstructs number with less-than-ten-digit part in middle correctly") {
      val expected = "32238195734329339946000000002536945765883352399886"
      val input = List("0", "3223819573", "4329339946", "25", "3694576588", "3352399886").map(BigInt(_))
      partsToString(input) shouldBe expected
    }

  }

  describe("addParts function") {

    it("should add numbers with no carry") {
      val input = List("0", "1111111111", "1111111111", "1111111111", "1111111111", "1111111111").map(BigInt(_))
      val expected = List("0", "2222222222", "2222222222", "2222222222", "2222222222", "2222222222").map(BigInt(_))
      addParts(input, input) shouldBe expected
    }

    it("should add numbers with one-place carry") {
      val input = List("0", "1111111111", "1111111111", "5000000000", "1111111111", "1111111111").map(BigInt(_))
      val expected = List("0", "2222222222", "2222222223", "0", "2222222222", "2222222222").map(BigInt(_))
      addParts(input, input) shouldBe expected
    }

    it("should add numbers with two-place carry") {
      val input1 = List("0", "1111111111", "4999999999", "5000000000", "1111111111", "1111111111").map(BigInt(_))
      val input2 = List("0", "1111111111", "5000000000", "5000000000", "1111111111", "1111111111").map(BigInt(_))
      val expected = List("0", "2222222223", "0", "0", "2222222222", "2222222222").map(BigInt(_))
      addParts(input1, input2) shouldBe expected
    }

  }

}
