package project_euler.solutions.question11

sealed trait GridTransition {

  val rowStrategy : DimensionIncrementStrategy

  val columnStrategy : DimensionIncrementStrategy

  def newPoint(point : Point, offset : Int) : Point = {

    val newRow = rowStrategy.increment(point.row, offset)

    val newColumn = columnStrategy.increment(point.column, offset)

    Point(newRow, newColumn)
  }

  def startPoints(grid : Grid, lineSize : Int) = {

    val rowRange = rowStrategy.getRange(grid.maxRowIndex, lineSize)

    val columnRange = columnStrategy.getRange(grid.maxColumnIndex, lineSize)

    for {row <- rowRange; column <- columnRange} yield Point(row, column)
  }

}

object HorizontalTransition extends GridTransition {

  override val rowStrategy = ZeroIncrement

  override val columnStrategy = PositiveIncrement

}

object VerticalTransition extends GridTransition {

  override val rowStrategy = PositiveIncrement

  override val columnStrategy = ZeroIncrement

}

object ForwardDiagonalTransition extends GridTransition {

  override val rowStrategy = NegativeIncrement

  override val columnStrategy = PositiveIncrement

}

object BackwardDiagonalTransition extends GridTransition {

  override val rowStrategy = PositiveIncrement

  override val columnStrategy = PositiveIncrement

}