package project_euler.app

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito.{when, verify, never}
import project_euler.solutions.Solution


class SolutionWrapperSpec extends FunSpec with Matchers with MockitoSugar {

  private def mockSolution(number : Int, title : String) = {

    val solution = mock[Solution]
    when(solution.questionNumber).thenReturn(number)
    when(solution.questionTitle).thenReturn(title)
    solution
  }

  private val mockSolution1 = mockSolution(1, "Solve a problem")
  private val mockSolution2 = mockSolution(2, "Solve another problem")
  private val mockSolutionList = List(mockSolution1, mockSolution2)

  private def testWrapper = new SolutionWrapper(mockSolutionList, mock[SolutionRunner])

  describe("SolutionWrapper") {

    it("should have expected toString") {
      testWrapper.toString shouldBe "1 - Solve a problem\n2 - Solve another problem"
    }

    describe("when running solutions") {

      it("should run full list when runAll is called") {
        val wrapper = testWrapper
        wrapper.runAll()
        verify(wrapper.runner).run(mockSolutionList)
      }

      it("should not run anything when runAll is called against empty list") {
        val wrapper = testWrapper
        wrapper.runAll()
        verify(testWrapper.runner, never()).run(_)
      }

      it("should run selected solution when runForQuestion is called") {
        val wrapper = testWrapper
        wrapper.runForQuestion(1)
        verify(wrapper.runner).run(List(mockSolution1))
      }

      it("should throw IllegalArgumentException when runForQuestion called but solution not available") {
        intercept[IllegalArgumentException](testWrapper.runForQuestion(3))
      }

    }

  }

}
