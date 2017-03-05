package project_euler.solutions

import scala.annotation.tailrec
import scala.collection.immutable.Range.BigInt

package object question3 {

  def isPrime(n : BigInt) : Boolean = !BigInt(2, n/2, 1).toStream.exists(n % _ == 0)

  private def nextPrimeFactor(n : BigInt) : BigInt = {

    @tailrec
    def recurse(i : BigInt) : BigInt = {
      if ((i == n) || (isPrime(i) && (n % i == 0))) i
      else recurse(i + 1)
    }

    recurse(2)
  }

  def primeFactors(n : BigInt) : Set[BigInt] = {

    case class State(remainingToFactor: BigInt, identifiedFactors: Set[BigInt])

    @tailrec
    def recurse(state : State) : State = {
      if (state.remainingToFactor == 1) state
      else {
        val next = nextPrimeFactor(state.remainingToFactor)
        recurse(
          State(
            state.remainingToFactor / next,
            state.identifiedFactors + next
          )
        )
      }
    }

    recurse(State(n, Set())).identifiedFactors
  }

}
