package project_euler.app

import Configuration.Parse
import project_euler.solutions._

import scala.util.{Failure, Success}

object EulerApp extends App {

  Parse(args) match {

    case None =>

      sys.exit(1)

    case Some(config) =>

      config.command match {

        case None =>
          sys.exit(1)

        case Some(command) =>

          command(ALL_SOLUTIONS) match {
            case Failure(e) => {
              println(s"Application failed - ${e.getMessage}")
              sys.exit(1)
            }
            case Success(_) =>
              sys.exit(0)
          }
      }
  }

}
