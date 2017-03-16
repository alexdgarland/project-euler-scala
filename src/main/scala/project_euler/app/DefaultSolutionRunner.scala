package project_euler.app

import project_euler.solutions.Solution


object DefaultSolutionRunner extends SolutionRunner {

  override def run(solutionList : List[Solution]) : Unit = {

    for (solution <- solutionList) {
      println(s"\n${solution.description}")
      println(s"Result -> ${solution.result}.\n")
    }
  }

}
