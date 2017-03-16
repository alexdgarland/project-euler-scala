package project_euler.app

import project_euler.app.Configuration.Command
import Configuration.Parse


object EulerApp extends App {

  val config = Parse(args)

  if (config.isEmpty)
    sys.exit(1)

  try {

    val configValues = config.get
    val solutions = SolutionWrapper.default

    configValues.command match {

      case Command.List =>
        println(s"Available solutions:\n$solutions")

      case Command.Run =>
        if (configValues.runAll)
          solutions.runAll()
        else
          solutions.runForQuestion(configValues.questionNumber.get)

    }

  }
  catch {
    case e : Exception =>
      println(s"Application Error: ${e.getMessage}")
      sys.exit(2)
  }

}
