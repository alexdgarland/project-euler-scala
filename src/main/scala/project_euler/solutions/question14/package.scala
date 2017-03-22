package project_euler.solutions

import scala.annotation.tailrec


package object question14 {

  private def nextCollatzElement(i : BigInt) : BigInt = {

    if (i % 2 == 0)
      i / 2
    else
      (i * 3) + 1
  }

  @tailrec
  def collatzSeq(
    i : BigInt,
    knownSeqs : Option[Map[BigInt, List[BigInt]]] = None,
    prepender : List[BigInt] => List[BigInt] = l => l
  ) : List[BigInt] = {

    knownSeqs
      .getOrElse(Map(BigInt(1) -> List(BigInt(1))))
      .get(i)
    match
    {

      case Some(sequence) =>

        prepender(sequence)

      case None =>

        collatzSeq(
          nextCollatzElement(i),
          knownSeqs,
          list => prepender(i :: list)
        )

    }
  }

  def collatzSeqsUnder(limit : BigInt) : Map[BigInt, List[BigInt]] = {

    def recurse(start : BigInt, knownSeqs : Option[Map[BigInt, List[BigInt]]]) : Map[BigInt, List[BigInt]] = {

      if (start >= limit)

        knownSeqs.get

      else {

        val newMap = knownSeqs.getOrElse(Map()) +
          (start -> collatzSeq(start, knownSeqs))

        recurse(start + 1, Some(newMap))
      }
    }

    recurse(1, None)
  }

  def longestCollatzUnder(limit : BigInt) : BigInt = {

    collatzSeqsUnder(limit)
      .maxBy {
        case (_, list) => list.length
      }
      ._1
  }

}
