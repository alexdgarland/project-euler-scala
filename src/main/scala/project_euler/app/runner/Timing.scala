package project_euler.app.runner

import com.github.nscala_time.time.Imports._


object Timing {

  private val formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")

  private def format(dateTime : DateTime) = formatter.print(dateTime)

  case class TimingDetails(start : DateTime, end : DateTime) {

    private val duration = (start to end).millis / 1000

    override def toString = {

      s"""Started: ${format(start)}
         |Ended: ${format(end)}
         |Duration: $duration seconds
         |""".stripMargin
    }

  }

  def withTiming[A](f : () => A) : (A, TimingDetails) = {

    val startTime = DateTime.now
    val result = f()
    val endTime = DateTime.now

    (result, TimingDetails(startTime, endTime))
  }

}
