package project_euler.app

import project_euler.app.runner.SolutionRunner
import project_euler.solutions.Solution
import scala.util.{Failure, Try}


sealed trait Command {

  def apply(solutionList : List[Solution]) : Try[Unit]

}


object ListSolutions extends Command {

  private def execute(solutionList : List[Solution]) : Unit = {
    println(s"Available solutions:")
    println(solutionList.map(
      s =>
        s"${s.questionNumber} - ${s.questionTitle}").mkString("\n")
    )
  }

  override def apply(solutionList : List[Solution]) : Try[Unit] = Try(execute(solutionList))

}


case class RunAllQuestions(runner : SolutionRunner) extends Command {

  override def apply(solutionList : List[Solution]) : Try[Unit] = Try(runner.run(solutionList))

}


case class RunOneQuestion(runner : SolutionRunner, questionNumber : Int) extends Command {

  override def apply(solutionList : List[Solution]) : Try[Unit] = {

    val matchingSolutions = solutionList.filter(_.questionNumber == questionNumber)

    if (matchingSolutions.isEmpty)
      Failure(new IllegalArgumentException(s"Solution not implemented for question $questionNumber."))
    else
      Try(runner.run(matchingSolutions))

  }

}
