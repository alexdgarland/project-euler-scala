package project_euler.solutions

import project_euler.shared_functions.isPrime

package object question7 {

  def nthPrime(n : Int) : Int = {
    Stream.from(2).filter(i => isPrime(BigInt(i))).take(n).last
  }

}
