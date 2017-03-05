package project_euler.app

import project_euler.solutions.getSolution

object EulerApp extends App {

  val questionNumber = args(0).toInt

  getSolution(questionNumber) match {
    case None =>
      println(s"ERROR - Solution not implemented for question $questionNumber.")
    case Some(solution) =>
      println(solution.description)
      println(s"Result is - ${solution.result}.")
  }

}
