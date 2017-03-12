package project_euler.app

import scala.util.{Failure, Success, Try}

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

  private val solutions = SolutionWrapper.default

  try {

    if (args.length == 0)
      throw new IllegalArgumentException(s"No arguments provided.")

    args(0) match {
      case "help" =>
        println(usage)
      case "list" =>
        println(s"Available solutions:\n$solutions")
      case "all" =>
        solutions.runAll()
      case arg =>
        Try(arg.toInt) match {
          case Success(i) =>
            solutions.runForQuestion(i)
          case Failure(_) =>
            val quote = '"'
            throw new IllegalArgumentException(s"Unexpected argument $quote$arg$quote.")
        }
    }

  }
  catch {
    case e : Exception =>
      println(s"ERROR - ${e.getMessage}")
      sys.exit(1)
  }

}
