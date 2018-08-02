package project_euler.app.runner

import project_euler.solutions.Solution
import Timing.withTiming

object DefaultRunner extends SolutionRunner {

  override def run(solutionList : List[Solution]) : Unit = {

    for (solution <- solutionList) {

      println(s"\n${solution.description}")

      val (result, timings) = withTiming(() => solution.result)

      println(s"Result -> $result.\n")
      println(timings)
    }
  }

}
