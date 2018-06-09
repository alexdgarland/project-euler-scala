package project_euler.app

import scopt.OptionParser


object Configuration {

  object Command extends Enumeration {
    type Mode = Value
    val None, List, Run = Value
  }

  case class AppConfig(
    command : Command.Mode = Command.None,
    runAll : Boolean = false,
    questionNumber : Option[Int] = None
  )

  val parser : OptionParser[AppConfig] = new OptionParser[AppConfig]("project_euler.sh") {

    head("\n****** Project Euler Solutions ******\n")

    help("help")
      .abbr("h")
      .text("prints this usage text")

    note("\nOne of the following commands must be chosen:\n")

    cmd("list")
      .text("List available solutions.")
      .action((_, c) => c.copy(command = Command.List))

    cmd("run")
      .text("Run one or all solutions.")
      .action((_, c) => c.copy(command = Command.Run))
      .children(
        opt[Unit]("all")
          .abbr("a")
          .text("run all available solutions")
          .action((_, c) => c.copy(runAll = true)),
        opt[Int]("question")
          .abbr("q")
          .text("run solution for selected question number")
          .action((i, c) => c.copy(questionNumber = Some(i)))
      )

    checkConfig {
      case AppConfig(Command.None, _, _) =>
        failure("Command not set.")
      case AppConfig(Command.Run, true, Some(_)) =>
        failure("question number and \"all\" option cannot both be set.")
      case AppConfig(Command.Run, false, None) =>
        failure("to run solutions, one of question number and \"all\" option must be set.")
      case _ =>
        success
    }
  }

  def Parse(args : Array[String]) : Option[AppConfig] = {

    parser.parse(args, AppConfig())
  }

}
