package project_euler.app

import java.util.Calendar
import java.util.Date

// This is overkill for an app this size but fancied writing it anyway.
// TODO : Could use Joda instead of java.util.

object Timing {

  case class TimingDetails(start : Date, end : Date) {

    override def toString = {

      val duration = (end.getTime - start.getTime) / 1000

      s"Started: $start.\nEnded: $end.\nDuration: $duration seconds.\n"
    }

  }

  def withTiming[A](f : () => A) : (A, TimingDetails) = {

    val startTime = Calendar.getInstance.getTime
    val result = f()
    val endTime = Calendar.getInstance.getTime

    (result, TimingDetails(startTime, endTime))
  }

}
