package project_euler.solutions.question4

import org.scalatest._


class Question4Spec extends FlatSpec with Matchers {

  behavior of "the isPalindrome function"

  it should  "identify a single-letter string as a palindrome" in {
    isPalindrome("1") shouldBe true
  }

  it should "identify a palindrome with an even number of letters" in {
    isPalindrome("1221") shouldBe true
  }

  it should "identify a palindrome with an odd number of letters" in {
    isPalindrome("12521") shouldBe true
  }

  it should "identify a non-palindrome with an even number of letters" in {
    isPalindrome("1231") shouldBe false
  }

  it should "identify a non-palindrome with an odd number of letters" in {
    isPalindrome("12551") shouldBe false
  }

  behavior of "the maxPalindrome function"

  it should "return 9009 for two-digit range" in {
    maxPalindromeProduct(1 to 99) shouldBe(9009)
  }

}
