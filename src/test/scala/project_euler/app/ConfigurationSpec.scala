package project_euler.app

import org.scalatest.{FunSpec, Matchers}
import Configuration.{AppConfig, parser}
import project_euler.app.runner.DefaultRunner


class ConfigurationSpec extends FunSpec with Matchers {

  describe("parser") {

    def testParse(args : String*) = parser.parse(args, AppConfig())

    def expectedConfig(command : Command) = Some(AppConfig(Some(command)))

    it("should fail if no args are provided") {
      testParse() shouldBe None
    }

    it("should fail if invalid command is provided") {
      testParse("prevaricate") shouldBe None
    }

    describe("with List command") {

      it("can be set successfully with no arguments") {
        testParse("list") shouldBe expectedConfig(ListSolutions)
      }

      it("fails to parse when given arguments") {
        testParse("list", "-a") shouldBe None
      }

    }

    describe("with Run command") {

      val expectedConfigForRunAll = expectedConfig(RunAllQuestions(DefaultRunner))
      val expectedConfigForQ1 = expectedConfig(RunOneQuestion(DefaultRunner, 1))

      it("can be run without question number") {
        testParse("run") shouldBe expectedConfigForRunAll
      }

      it("can have question number set with long version of argument") {
        testParse("run", "--question", "1") shouldBe expectedConfigForQ1
      }

      it("can have question number set with short version of argument") {
        testParse("run", "-q", "1") shouldBe expectedConfigForQ1
      }

      it("fails to parse when given extra arguments") {
        testParse("run", "-q", "1", "-a") shouldBe None
      }

    }

  }

}
