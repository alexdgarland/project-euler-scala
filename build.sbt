import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "project_euler",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Project Euler",
    libraryDependencies += scopt,
    libraryDependencies += scalaTest % Test,
    libraryDependencies += mockito % Test
  )
