package project_euler.solutions.question11

trait DimensionIncrementStrategy {

  def multiplier : Int

  def increment(startValue : Int, offset : Int) : Int = startValue + (offset * multiplier)

  def getRange(maxIndex : Int, lineSize : Int) : Range

}

object ZeroIncrement extends DimensionIncrementStrategy {

  override def multiplier = 0

  override def getRange(maxIndex: Int, lineSize: Int) = 0 to maxIndex

}

object PositiveIncrement extends DimensionIncrementStrategy {

  override def multiplier = 1

  override def getRange(maxIndex: Int, lineSize: Int) = 0 to maxIndex - (lineSize - 1)

}

object NegativeIncrement extends DimensionIncrementStrategy {

  override def multiplier = -1

  override def getRange(maxIndex: Int, lineSize: Int) = (lineSize - 1) to maxIndex

}
