package project_euler.solutions

package object question10 {

  def primesBelow(limit : Int) : Vector[Int] = {

    def recurse(candidate : Int, knownPrimes : Vector[Int]) : Vector[Int] = {

      if (candidate >= limit)

        knownPrimes

      else {

        val isPrime = knownPrimes.par.forall(p => candidate % p != 0)

        val nextKnownPrimes =
          if (isPrime)
            knownPrimes :+ candidate
          else
            knownPrimes

        recurse(candidate + 1, nextKnownPrimes)
      }
    }

    recurse(2, Vector.empty[Int])
  }

}
