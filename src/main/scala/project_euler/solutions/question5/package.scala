package project_euler.solutions

import scala.annotation.tailrec


package object question5 {

  def smallestCommonMultiple(range : Range) : Int = {

    def isCommonMultiple(i : Int) = range.forall(j => i % j == 0)

    @tailrec
    def recurse(i : Int) : Int = if (isCommonMultiple(i)) i
    else recurse(i + 1)

    recurse(1)

  }

}
