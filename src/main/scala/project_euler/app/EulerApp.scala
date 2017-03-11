package project_euler.app

import scala.util.{Failure, Success, Try}
import Run.{runAll, findSolution, runSolution}

object EulerApp extends App {

  // Workaround for inserting double-quotes into interpolated string
  private val quote = '"'

  private def exitWithError(message : String) : Unit = {
    println(s"ERROR - $message")
    sys.exit(1)
  }

  private def handleQuestionNumber(n : Int) = {
    findSolution(n) match {
      case Some(solution) =>
        runSolution(solution)
      case None =>
        exitWithError(s"Solution not implemented for question $n.")
    }
  }

  args(0) match {
    case "all" =>
      runAll()
    case arg =>
      Try(arg.toInt) match {
        case Success(i) =>
          handleQuestionNumber(i)
        case Failure(_) =>
          exitWithError(s"Unexpected argument $quote$arg$quote.")
      }
  }

}
