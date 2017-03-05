package project_euler.solutions

import scala.collection.immutable.Range.BigInt

package object question3 {

  def isPrime(n : BigInt) : Boolean = {
    !BigInt(2,  n/2, 1).toStream.exists(n % _ == 0)
  }

  implicit class FactorableBigInt(i : BigInt) {
    def isFactorOf(n : BigInt) : Boolean = n % i == 0
  }

  def primeFactors(n : BigInt) : List[BigInt] = {

    // This is an imperative-style hack required because Scala Ranges won't go above Int.MaxValue
    def findNextPrime(n : BigInt) : BigInt = {
      var i : BigInt  = 2
      var nextPrime = n
      while (i < n && nextPrime == n) {
        if (isPrime(i) && (i isFactorOf n)) nextPrime = i
        i += 1
      }
      nextPrime
    }

    def recurse(remainingToFactor: BigInt, identifiedFactors: Set[BigInt]) : (BigInt, Set[BigInt]) = {
      if (remainingToFactor == 1) (remainingToFactor, identifiedFactors)
      else {
        val next = findNextPrime(remainingToFactor)
        recurse(remainingToFactor / next, identifiedFactors + next)
      }
    }

    recurse(n, Set())._2.toList
  }

}
