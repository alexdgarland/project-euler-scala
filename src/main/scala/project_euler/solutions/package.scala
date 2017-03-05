package project_euler

package object solutions {

  private val solutionList = List[Solution](
    Question1Solution,
    Question2Solution,
    Question3Solution,
    Question4Solution
  )

  def getSolution(questionNumber: Int) : Option[Solution] = solutionList.find(_.questionNumber == questionNumber)

}