package project_euler.app

import org.scalatest.{FunSpec, Matchers}
import Configuration.{parser, AppConfig, Command}


class ConfigurationSpec extends FunSpec with Matchers {

  describe("parser") {

    def testParse(args : Array[String]) = parser.parse(args, AppConfig())

    it("should fail if no args are provided") {
      testParse(Array[String]()) shouldBe None
    }

    describe("with List command") {

      it("can be set successfully with no arguments") {
        testParse(Array("list")).get.command shouldBe Command.List
      }

      it("fails to parse when given arguments") {
        testParse(Array("list", "-a")) shouldBe None
      }

    }

    describe("with Run command") {

      it("should fail when requested without \"all\" flag or question number") {
        testParse(Array("run")) shouldBe None
      }

      it("can have question number set with long version of argument") {
        val config = testParse(Array("run", "--question", "1")).get
        config.command shouldBe Command.Run
        config.questionNumber shouldBe Some(1)
      }

      it("can have question number set with short version of argument") {
        val config = testParse(Array("run", "-q", "1")).get
        config.command shouldBe Command.Run
        config.questionNumber shouldBe Some(1)
      }

      it("can have \"all\" flag set with long version of argument") {
        val config = testParse(Array("run", "--all")).get
        config.command shouldBe Command.Run
        config.runAll shouldBe true
      }

      it("can have \"all\" flag set with short version of argument") {
        val config = testParse(Array("run", "-a")).get
        config.command shouldBe Command.Run
        config.runAll shouldBe true
      }

      it("should fail when requested with both \"all\" flag and question number") {
        testParse(Array("run", "-a", "-q", "1")) shouldBe None
      }

    }

  }

}
