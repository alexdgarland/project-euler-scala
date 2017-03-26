package project_euler.solutions.question11


case class Grid(rows : List[List[Int]]) {

  val maxRowIndex = rows.length - 1

  val maxColumnIndex = rows.head.length - 1

  def pointValue(point : Point) = rows(point.row)(point.column)

}
