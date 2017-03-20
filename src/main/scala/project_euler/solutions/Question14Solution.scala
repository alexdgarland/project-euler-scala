package project_euler.solutions

import project_euler.solutions.question14.collatzSequence


object Question14Solution extends Solution {

  override def questionNumber = 14

  override def questionTitle = "Longest Collatz sequence"

  override def questionBody = {

    s"""
       |The following iterative sequence is defined for the set of positive integers:
       |
       |  n -> n / 2 (n is even)
       |  n -> 3n + 1 (n is odd)
       |
       |Using the rule above and starting with 13, we generate the following sequence:
       |
       |  13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
       |
       |It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
       |Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
       |
       |Which starting number, under one million, produces the longest chain?
       |
       |NOTE: Once the chain starts the terms are allowed to go above one million.
       |
       |""".stripMargin

  }

  override def result = (1 until 1000000).maxBy(collatzSequence(_).length).toString

}
