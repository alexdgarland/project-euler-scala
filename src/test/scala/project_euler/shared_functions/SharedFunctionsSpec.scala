package project_euler.shared_functions

import org.scalatest._

class SharedFunctionsSpec extends FlatSpec with Matchers {

  behavior of "the isPrime function"

  it should  "identify 3 as prime" in {
    isPrime(BigInt(3)) shouldBe true
  }

  it should  "identify 4 as non-prime" in {
    isPrime(BigInt(4)) shouldBe false
  }

  it should "identify 10 as non-prime" in {
    isPrime(BigInt(10)) shouldBe false
  }

}
