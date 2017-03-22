package project_euler.solutions


package object question14 {

  private def nextCollatzElement(i : BigInt) : BigInt = {

    if (i % 2 == 0)
      i / 2
    else
      (i * 3) + 1
  }

  def collatzSequenceFrom(startingPoint : Int) : Stream[BigInt] = {

    lazy val seq : Stream[BigInt] = startingPoint #:: seq.map(nextCollatzElement)

    seq
      .takeWhile(_ != 1)
      .append(Stream(1))
  }


  def longestCollatzUnder(limit : Int) : Int = {

    case class Result(startingPoint : Int, sequenceLength : Int)

    (1 until limit)
      .par
      .map {
        i =>
          val sequenceLength = collatzSequenceFrom(i).length
          Result(i, sequenceLength)
      }
      .maxBy(_.sequenceLength)
      .startingPoint
  }

}
