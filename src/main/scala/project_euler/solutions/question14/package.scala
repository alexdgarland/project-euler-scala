package project_euler.solutions

package object question14 {

  def collatzSequence(i : Int) : Stream[Int] = {

    val next = (n : Int) =>
      if (n % 2 == 0) n / 2
      else (n * 3) + 1

    lazy val sequence : Stream[Int] = i #:: sequence.map(next)

    sequence
      .takeWhile(_ != 1)
      .append(Stream(1))
  }

}
