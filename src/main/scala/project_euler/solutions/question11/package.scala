package project_euler.solutions

package object question11 {

  def getLines(grid : Grid, lineSize : Int, transition : GridTransition) = {

    def getLineFromPoint(start : Point) = {

      (0 until lineSize).map {
        offset =>
          grid.pointValue(transition.newPoint(start, offset))
      }
    }

    transition
      .startPoints(grid, lineSize)
      .map(getLineFromPoint)
  }

  val gridTransitions = List(
    HorizontalTransition,
    VerticalTransition,
    ForwardDiagonalTransition,
    BackwardDiagonalTransition
  )

}
