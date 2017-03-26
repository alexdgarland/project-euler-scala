package project_euler

import java.nio.file.Paths


package object resource_handling {

  def getResourceLines(directory : String, fileName : String) : List[String] = {

    val path = Paths.get(directory, fileName)

    scala.io.Source
      .fromResource(path.toString)
      .getLines
      .toList
  }

}
