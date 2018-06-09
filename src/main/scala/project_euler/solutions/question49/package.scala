package project_euler.solutions

import project_euler.shared_functions.isPrime
import scala.collection.SortedSet

package object question49 {

  def uniquePermutations(i : Int) : SortedSet[Int] = {

    // Private extension purely for single-use syntactic sugar
    implicit class extendedString(s : String) {
      def excludingIndex(i : Int) : String = {
        s.slice(0, i) + s.slice(i + 1, s.length)
      }
    }

    def charPermutations(remaining : String, processed : String = "") : SortedSet[String] = {
      if (remaining.length == 1) {
        SortedSet(s"$processed${remaining.head}")
      }
      else {
        remaining
          .indices
          .map(i => charPermutations(remaining.excludingIndex(i), processed + remaining(i)))
          .reduce((a, b) => a.union(b))
      }
    }
    charPermutations(i.toString).map(_.toInt)
  }

  def ascendingCombinations(sortedSet: SortedSet[Int], desiredSize : Int = 3) : List[SortedSet[Int]] = {
    if (sortedSet.size == desiredSize) {
      List(sortedSet)
    }
    else if (desiredSize == 1) {
      sortedSet.map(SortedSet(_)).toList
    }
    else {
      val first = ascendingCombinations(sortedSet.tail, desiredSize -1).map(_ + sortedSet.head)
      val second = ascendingCombinations(sortedSet.tail, desiredSize)
      first ::: second
    }
  }

  def newSolutions : Set[SortedSet[Int]] = {

    val fourDigitPrimes = (1000 to 9999).filter(isPrime(_))

    val getPrimePermutations = (i : Int) =>
      uniquePermutations(i).filter(p => fourDigitPrimes.contains(p))

    val sameDiff = (s : SortedSet[Int]) => {
      val l = s.toList
      (l(1) - l.head) == (l(2) - l(1))
    }

    val isNewSolution = (s: SortedSet[Int]) => s != SortedSet(1487, 4817, 8147)

    fourDigitPrimes
      .map(getPrimePermutations)
      .filter(_.size >= 3)
      .flatMap(ascendingCombinations(_))
      .filter(s => sameDiff(s))
      .filter(s => isNewSolution(s))
      .toSet
  }

}
