package project_euler

package object solutions {

  private val solutionList = List[Solution](
    Question1Solution,
    Question2Solution,
    Question3Solution,
    Question4Solution,
    Question5Solution,
    Question6Solution,
    Question7Solution,
    Question8Solution,
    Question9Solution,
    Question10Solution
  )

  def getSolution(questionNumber: Int) : Option[Solution] = solutionList.find(_.questionNumber == questionNumber)

}