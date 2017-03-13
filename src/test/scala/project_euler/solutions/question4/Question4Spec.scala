package project_euler.solutions.question4

import org.scalatest.{FunSpec, Matchers}

class Question4Spec extends FunSpec with Matchers {

  describe("the isPalindrome function") {

    it("should identify a single-letter string as a palindrome") {
      isPalindrome("1") shouldBe true
    }

    it("should identify a palindrome with an even number of letters") {
      isPalindrome("1221") shouldBe true
    }

    it("should identify a palindrome with an odd number of letters") {
      isPalindrome("12521") shouldBe true
    }

    it("should identify a non-palindrome with an even number of letters") {
      isPalindrome("1231") shouldBe false
    }

    it("should identify a non-palindrome with an odd number of letters") {
      isPalindrome("12551") shouldBe false
    }

  }

  describe("the maxPalindrome function") {

    it("should return 9009 for two-digit range") {
      maxPalindromeProduct(1 to 99) shouldBe 9009
    }

  }

}
