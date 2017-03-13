package project_euler.shared_functions

import org.scalatest.{FunSpec, Matchers}

class SharedFunctionsSpec extends FunSpec with Matchers {

  describe("the isPrime function") {

    it("should identify 3 as prime") {
      isPrime(BigInt(3)) shouldBe true
    }

    it("should identify 4 as non-prime") {
      isPrime(BigInt(4)) shouldBe false
    }

    it("should identify 10 as non-prime") {
      isPrime(BigInt(10)) shouldBe false
    }

  }

}
