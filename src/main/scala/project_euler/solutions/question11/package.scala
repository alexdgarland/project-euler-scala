package project_euler.solutions

package object question11 {

  import Grid.Point

  private def getLines(
    grid : Grid,
    lineSize : Int,
    rowRange : Range,
    columnRange : Range,
    movePoint : (Point, Int) => Point
  ) = {

    val lineStartPoints : IndexedSeq[Point] = for {
      row <- rowRange
      column <- columnRange
    } yield Point(row, column)

    def getLine(startingPoint: Point) = {
      (0 until lineSize).map {
        offset =>
          val point = movePoint(startingPoint, offset)
          grid.pointValue(point)
      }
    }

    lineStartPoints.map(getLine)
  }

  def horizontalLinesOfSize(lineSize : Int, grid : Grid) = {
    getLines(
      grid,
      lineSize,
      0 to grid.maxRowIndex,
      0 to grid.maxColumnIndex - (lineSize - 1),
      (p, o) => Point(p.row, p.column + o)
    )
  }

  def verticalLinesOfSize(lineSize : Int, grid : Grid) = {
    getLines(
      grid,
      lineSize,
      0 to grid.maxRowIndex - (lineSize - 1),
      0 to grid.maxColumnIndex,
      (p, o) => Point(p.row + o, p.column)
    )
  }

  def forwardDiagonalLinesOfSize(lineSize : Int, grid : Grid)  = {
    getLines(
      grid,
      lineSize,
      (lineSize - 1) to grid.maxRowIndex,
      0 to grid.maxColumnIndex - (lineSize - 1),
      (p, o) => Point(p.row - o, p.column + o)
    )
  }

  def backwardDiagonalLinesOfSize(lineSize : Int, grid : Grid) = {
    getLines(
      grid,
      lineSize,
      0 to grid.maxRowIndex - (lineSize - 1),
      0 to grid.maxColumnIndex - (lineSize - 1),
      (p, o) => Point(p.row + o, p.column + o)
    )
  }



}
