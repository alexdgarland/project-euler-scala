package project_euler.app.runner

import project_euler.solutions.Solution


trait SolutionRunner {

  def run(solutionList : List[Solution]) : Unit

}
