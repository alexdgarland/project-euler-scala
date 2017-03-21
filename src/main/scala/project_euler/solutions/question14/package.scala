package project_euler.solutions

import scala.annotation.tailrec


package object question14 {

  private def nextCollatzElement(i : Int) = {

    if (i % 2 == 0)
      i / 2
    else
      (i * 3) + 1
  }

  @tailrec
  def collatzSeq(
    i : Int,
    knownSeqs : Option[Map[Int, List[Int]]] = None,
    prepender : List[Int] => List[Int] = l => l
  ) : List[Int] = {

    knownSeqs
      .getOrElse(Map(1 -> List(1)))
      .get(i) match {

      case Some(sequence) =>
        prepender(sequence)

      case None =>
        collatzSeq(nextCollatzElement(i), knownSeqs, list => prepender(i :: list))

    }
  }

  def collatzSeqsUnder(limit : Int) : Map[Int, List[Int]] = {

    def recurse(start : Int, knownSeqs : Option[Map[Int, List[Int]]]) : Map[Int, List[Int]] = {

      if (start >= limit)
        knownSeqs.get
      else {
        val newMap = knownSeqs.getOrElse(Map()) + (start -> collatzSeq(start, knownSeqs))
        recurse(start + 1, Some(newMap))
      }
    }

    recurse(1, None)
  }

  def longestCollatzUnder(limit : Int) : Int = {

    collatzSeqsUnder(limit)
      .maxBy {
        case (_, list) => list.length
      }
      ._1
  }

}
