package project_euler.solutions

package object question10 {

  def primesBelow(limit : Int) : Vector[Int] = {

    def recurse(nextCandidate : Int, knownPrimes : Vector[Int]) : Vector[Int] = {

      if (nextCandidate >= limit)
        knownPrimes
      else {
        recurse(
          nextCandidate + 1,
          if (knownPrimes.par.forall(p => nextCandidate % p != 0))
            knownPrimes :+ nextCandidate
          else
            knownPrimes
        )
      }
    }

    recurse(2, Vector.empty[Int])
  }

}
