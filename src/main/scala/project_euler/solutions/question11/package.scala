package project_euler.solutions

import project_euler.resource_handling.getResourceLines


package object question11 {

  lazy val gridFileLines = getResourceLines("question11", "grid.txt")

  lazy val questionGrid : Grid = {

    def parseLine(line: String) =
      line.split(" ")
        .map(_.toInt)
        .toList

    val parsed = gridFileLines.map(parseLine)

    Grid(parsed)
  }

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
