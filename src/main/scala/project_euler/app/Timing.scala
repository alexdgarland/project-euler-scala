package project_euler.app

import java.util.Calendar
import java.util.Date

// This is overkill for an app this size but fancied writing it anyway.
// TODO : Could use Joda instead of java.util.

object Timing {

  case class TimingDetails(startTime : Date, endTime : Date) {

    override def toString = {

      val duration = (endTime.getTime - startTime.getTime) / 1000
      s"Calculation started at $startTime.\n" +
        s"Calculation ended at $endTime.\n" +
        s"Elapsed time was $duration seconds.\n"
    }

  }

  def withTiming[A](f : () => A) : (A, TimingDetails) = {

    val startTime = Calendar.getInstance.getTime
    val result = f()
    val endTime = Calendar.getInstance.getTime

    (result, TimingDetails(startTime, endTime))
  }

}
