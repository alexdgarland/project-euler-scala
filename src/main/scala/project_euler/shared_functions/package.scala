package project_euler

import scala.collection.immutable.Range.BigInt

package object shared_functions {

  def isPrime(n : BigInt) : Boolean = !BigInt.inclusive(2, n/2, 1).toStream.exists(n % _ == 0)

}
