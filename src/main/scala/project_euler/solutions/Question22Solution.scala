package project_euler.solutions

import project_euler.solutions.question22.{sortedNamesWithIndex, getTotalValueOfSortedNames}


object Question22Solution extends Solution {

  override def questionNumber = 22

  override def questionTitle = "Names scores"

  override def questionBody = {

    s"""
       |Using https://projecteuler.net/project/resources/p022_names.txt,
       |a 46K text file containing over five-thousand first names,
       |begin by sorting it into alphabetical order.
       |
       |Then working out the alphabetical value for each name,
       |multiply this value by its alphabetical position in the list to obtain a name score.
       |
       |For example, when the list is sorted into alphabetical order, COLIN,
       |which is worth 3 + 15 + 12 + 9 + 14 = 53,
       |is the 938th name in the list.
       |So, COLIN would obtain a score of 938 × 53 = 49714.
       |
       |What is the total of all the name scores in the file?
       |""".stripMargin

  }

  override def result = getTotalValueOfSortedNames(sortedNamesWithIndex).toString

}
