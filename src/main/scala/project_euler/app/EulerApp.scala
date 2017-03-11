package project_euler.app

import scala.util.{Failure, Success, Try}
import Run.{solutionList, runAll, findSolution, runSolution}

object EulerApp extends App {

  // TODO - decide if and when it's worth moving argument handling into scopt

  private val usage = """
                       |Project Euler Solution Runner App
                       |
                       |Requires one argument, which should be either:
                       |  - "help" to show this usage information
                       |  - "list" to list out implemented solutions
                       |  - "all" to run all solutions in order
                       |  - an integer value for the specific question you want the solution for""".stripMargin

  // Workaround for inserting double-quotes into interpolated string
  private val quote = '"'

  private def exitWithUsageError(message : String) : Unit = {
    println(s"ERROR - $message")
    println(usage)
    sys.exit(1)
  }

  private def handleQuestionNumber(n : Int) = {
    findSolution(n) match {
      case Some(solution) =>
        runSolution(solution)
      case None =>
        exitWithUsageError(s"Solution not implemented for question $n.")
    }
  }

  if (args.length == 0)
    exitWithUsageError(s"No arguments provided.")

  args(0) match {
    case "help" =>
      println(usage)
    case "list" =>
      println(s"Available solutions:\n$solutionList")
    case "all" =>
      runAll()
    case arg =>
      Try(arg.toInt) match {
        case Success(i) =>
          handleQuestionNumber(i)
        case Failure(_) =>
          exitWithUsageError(s"Unexpected argument $quote$arg$quote.")
      }
  }

}
