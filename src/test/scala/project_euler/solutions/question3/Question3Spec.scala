package project_euler.solutions.question3

import org.scalatest._

class Question3Spec extends FlatSpec with Matchers {


  behavior of "the isPrime function"

  it should  "identify 3 as prime" in {
    isPrime(BigInt(3)) shouldBe true
  }

  it should "identify 10 as non-prime" in {
    isPrime(BigInt(10)) shouldBe false
  }


  behavior of "the isFactorOf implicit method"

  it should "identify 2 as a factor of 4" in {
    (BigInt(2) isFactorOf BigInt(4)) shouldBe true
  }

  it should "identify 3 as not a factor of 4" in {
    (BigInt(3) isFactorOf BigInt(4)) shouldBe false
  }


  behavior of "the primeFactors function"

  private def examplePrimeFactors = primeFactors(BigInt(13195))

  it should "get correct number of factors" in {
    examplePrimeFactors.size shouldBe 4
  }

  it should "return correct individual factors" in {
    examplePrimeFactors should contain (BigInt(5))
    examplePrimeFactors should contain (BigInt(7))
    examplePrimeFactors should contain (BigInt(13))
    examplePrimeFactors should contain (BigInt(29))
  }

  it should "return have correct largest prime factor" in {
    examplePrimeFactors.max shouldBe BigInt(29)
  }

  it should "return only a single element for powers of the same prime factor" in {
    primeFactors(BigInt(8)) shouldBe List(2)
  }


}
