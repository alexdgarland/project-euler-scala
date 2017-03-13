package project_euler.app

import org.scalatest.{FlatSpec, Matchers}
import Configuration.{parser, AppConfig, Command}

class ConfigurationSpec extends FlatSpec with Matchers {

  behavior of "parser"

  def testParse(args : Array[String]) = parser.parse(args, AppConfig())

  it should "fail if no args are provided" in {
    testParse(Array[String]()) shouldBe None
  }

  it should "set command to List when requested with long argument form" in {
    testParse(Array("list")).get.command shouldBe Command.List
  }

  it should "fail when Run command is requested without \"all\" flag or question number" in {
    testParse(Array("run")) shouldBe None
  }

  it should "set command to Run with long version of question number argument when requested" in {
    val config = testParse(Array("run", "--question", "1")).get
    config.command shouldBe Command.Run
    config.questionNumber shouldBe Some(1)
  }

  it should "set command to Run with short version of question number argument when requested" in {
    val config = testParse(Array("run", "-q", "1")).get
    config.command shouldBe Command.Run
    config.questionNumber shouldBe Some(1)
  }

  it should "set command to Run when requested with long version of \"all\" flag" in {
    val config = testParse(Array("run", "--all")).get
    config.command shouldBe Command.Run
    config.runAll shouldBe true
  }

  it should "set command to Run when requested with short version of \"all\" flag" in {
    val config = testParse(Array("run", "-a")).get
    config.command shouldBe Command.Run
    config.runAll shouldBe true
  }

  it should "fail when Run command is requested with both \"all\" flag and question number" in {
    testParse(Array("run", "-a", "-q", "1")) shouldBe None
  }

}
