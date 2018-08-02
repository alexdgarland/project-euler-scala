package project_euler.app

import project_euler.app.runner.DefaultRunner
import scopt.OptionParser

object Configuration {

  case class AppConfig(
    command : Option[Command] = None
  )

  val parser : OptionParser[AppConfig] = new OptionParser[AppConfig]("project_euler.sh") {

    head("\n****** Project Euler Solutions ******\n")

    help("help")
      .abbr("h")
      .text("prints this usage text")

    note("\nOne of the following commands must be chosen:\n")

    cmd("list")
      .text("List available solutions.")
      .action((_, c) => c.copy(command = Some(ListSolutions)))

    cmd("run")
      .text("Run one or all solutions.")
      .action((_, c) => c.copy(command = Some(RunAllQuestions(DefaultRunner))))
      .children(
        opt[Int]("question")
          .abbr("q")
          .text("Run solution for selected question number. If omitted, run all questions.")
          .action((n, c) => c.copy(command = Some(RunOneQuestion(DefaultRunner, n))))
      )

    checkConfig {
      case AppConfig(None) =>
        failure("Command not set.")
      case _ =>
        success
    }
  }

  def Parse(args : Array[String]) : Option[AppConfig] = {
    parser.parse(args, AppConfig())
  }

}
