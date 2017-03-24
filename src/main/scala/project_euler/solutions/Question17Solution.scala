package project_euler.solutions

import project_euler.solutions.question17.characterCount


object Question17Solution extends Solution {

  override def questionNumber = 17

  override def questionTitle = "Number letter counts"

  override def questionBody = {

    s"""
       |If the numbers 1 to 5 are written out in words: one, two, three, four, five,
       |then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
       |
       |If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words,
       |how many letters would be used?
       |
       |""".stripMargin

  }

  override def result = (1 to 1000).map(characterCount).sum.toString

}
