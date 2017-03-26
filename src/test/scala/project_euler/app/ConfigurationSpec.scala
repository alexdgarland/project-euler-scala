package project_euler.app

import org.scalatest.{FunSpec, Matchers}
import Configuration.{parser, AppConfig, Command}


class ConfigurationSpec extends FunSpec with Matchers {

  describe("parser") {

    def testParse(args : String*) = parser.parse(args, AppConfig())

    it("should fail if no args are provided") {
      testParse() shouldBe None
    }

    describe("with List command") {

      it("can be set successfully with no arguments") {
        testParse("list") shouldBe Some(AppConfig(Command.List, runAll = false, None))
      }

      it("fails to parse when given arguments") {
        testParse("list", "-a") shouldBe None
      }

    }

    describe("with Run command") {

      it("should fail when requested without \"all\" flag or question number") {
        testParse("run") shouldBe None
      }

      it("can have question number set with long version of argument") {
        testParse("run", "--question", "1") shouldBe Some(AppConfig(Command.Run, runAll = false, Some(1)))
      }

      it("can have question number set with short version of argument") {
        testParse("run", "-q", "1") shouldBe Some(AppConfig(Command.Run, runAll = false, Some(1)))
      }

      it("can have \"all\" flag set with long version of argument") {
        testParse("run", "--all") shouldBe Some(AppConfig(Command.Run, runAll = true, None))
      }

      it("can have \"all\" flag set with short version of argument") {
        testParse("run", "-a") shouldBe Some(AppConfig(Command.Run, runAll = true, None))
      }

      it("should fail when requested with both \"all\" flag and question number") {
        testParse("run", "-a", "-q", "1") shouldBe None
      }

    }

  }

}
