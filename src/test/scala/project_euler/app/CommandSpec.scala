package project_euler.app

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito.{verify, when}
import project_euler.app.runner.SolutionRunner
import project_euler.solutions.Solution
import scala.util.{Failure, Success}


class CommandSpec extends FunSpec with Matchers with MockitoSugar {

  private def mockSolution(number : Int, title : String) = {
    val solution = mock[Solution]
    when(solution.questionNumber).thenReturn(number)
    when(solution.questionTitle).thenReturn(title)
    solution
  }

  private val mockSolution1 = mockSolution(1, "Solve a problem")
  private val mockSolution2 = mockSolution(2, "Solve another problem")
  private val mockSolutionList = List(mockSolution1, mockSolution2)

  def testForSuccess(commandCreator : SolutionRunner => Command, expectedList : List[Solution]) : Unit = {
    val mockRunner = mock[SolutionRunner]
    val command = commandCreator(mockRunner)
    command(mockSolutionList) shouldBe Success()
    verify(mockRunner).run(expectedList)
  }

  describe("RunAllQuestions command") {

    it("should run full list successfully") {
      testForSuccess(RunAllQuestions, mockSolutionList)
    }

  }

  describe("RunOneQuestion command") {

      it("should run selected solution successfully when available") {
        testForSuccess(
          (r : SolutionRunner) => RunOneQuestion(r, 1),
          List(mockSolution1)
        )
      }

      it("should fail when solution is not available") {
        val mockRunner = mock[SolutionRunner]
        val runOneCommand = RunOneQuestion(mockRunner, 3)
        runOneCommand(mockSolutionList) match {
          case Success(_) =>
            fail("Command should fail for missing solution but succeeded.")
          case Failure(e) =>
            e.getMessage shouldBe "Solution not implemented for question 3."
        }
      }

    }

}
