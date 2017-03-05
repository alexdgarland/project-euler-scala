package project_euler.solutions

trait Solution {

  def questionNumber : Int

  def questionTitle : String

  def questionBody : String

  def description = s"Question $questionNumber - $questionTitle\n$questionBody"

  def result : String

}
