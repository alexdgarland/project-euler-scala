package project_euler.app

import project_euler.solutions.Solution


trait SolutionRunner {

  def run(solutionList : List[Solution]) : Unit

}
