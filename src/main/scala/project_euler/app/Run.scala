package project_euler.app

import project_euler.solutions._

object Run {

  private val solutions = List(
    Question1Solution,
    Question2Solution,
    Question3Solution,
    Question4Solution,
    Question5Solution,
    Question6Solution,
    Question7Solution,
    Question8Solution,
    Question9Solution,
    Question10Solution
  )

  def findSolution(questionNumber : Int) : Option[Solution] =
    solutions.find(_.questionNumber == questionNumber)

  def runSolution(solution: Solution) : Unit = {
    println(s"\n${solution.description}")
    println(s"Result -> ${solution.result}.\n")
  }

  def runAll() : Unit = {
    for (solution <- solutions) {
      runSolution(solution)
    }
  }

}
