package project_euler.app

import project_euler.solutions._


case class SolutionWrapper(solutionList : List[Solution], runner : SolutionRunner) {

  override def toString : String =
    solutionList.map(s => s"${s.questionNumber} - ${s.questionTitle}").mkString("\n")

  def runAll() : Unit =
    runner.run(solutionList)

  def runForQuestion(questionNumber : Int) : Unit = {

    val matchingSolutions = solutionList.filter(_.questionNumber == questionNumber)
    if (matchingSolutions.isEmpty)
      throw new IllegalArgumentException(s"Solution not implemented for question $questionNumber.")
    runner.run(matchingSolutions)
  }

}

object SolutionWrapper {

  private val allSolutions = List(
    Question1Solution,
    Question2Solution,
    Question3Solution,
    Question4Solution,
    Question5Solution,
    Question6Solution,
    Question7Solution,
    Question8Solution,
    Question9Solution,
    Question10Solution,
    Question11Solution,
    Question12Solution,
    Question13Solution,
    Question14Solution,
    Question17Solution
  )

  val default : SolutionWrapper = new SolutionWrapper(allSolutions, DefaultSolutionRunner)

}
