package project_euler.solutions

import project_euler.solutions.question49.{ascendingCombinations, newSolutions}

import scala.collection.SortedSet

object Question49Solution extends Solution {

  override def questionNumber : Int = 49

  override def questionTitle : String = "Prime permutations"

  override def questionBody : String =
    """
      |The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
      |   (i) each of the three terms are prime, and,
      |   (ii) each of the 4-digit numbers are permutations of one another.
      |
      |There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
      |
      |What 12-digit number do you form by concatenating the three terms in this sequence?
      |
      |***NB*** : I wasn't completely clear on the requirement for this question -
      |specifically what the difference between the first-second / second-third primes needed to be.
      |Should it be exactly 3330, should it just be the same for both, or does it not matter?
      |It turns out that it's the first, which would have allowed me to write even simpler code.
      |However, having written code which allowed me to explore all the permutations
      |(and which does so quite fast and reasonably cleanly), I decided to leave it in place!
      |
      |""".stripMargin

  override def result : String = {
    val solution = newSolutions.head
    val prime1 = solution.head
    val prime2 = solution.slice(1, 2).head
    val prime3 = solution.slice(2, 3).head
    s"$prime1$prime2$prime3"
  }

}
