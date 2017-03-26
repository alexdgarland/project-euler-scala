package project_euler.solutions

import project_euler.resource_handling.getResourceLines


package object question22 {

  lazy val rawNames = getResourceLines("question22", "p022_names.txt")
    .head
    .split(",")
    .map(_.replaceAll("\"", ""))
    .toList

  lazy val sortedNamesWithIndex : List[(Int, String)] = {
    val sorted = rawNames.sorted
    (for (index <- 1 to sorted.length)
      yield (index, sorted(index - 1)))
      .toList
  }

  def nameValue(name : String) : Int = {

    name.map(_.charValue - ('A'.charValue - 1)).sum
  }

  def getTotalValueOfSortedNames(list : List[(Int, String)]) : Int = {

    list.map {
      case (index, name) =>
        index * nameValue(name)
    }.sum
  }

}
