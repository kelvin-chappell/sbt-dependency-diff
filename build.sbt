ThisBuild / version := "0.1.11-SNAPSHOT"

ThisBuild / organization := "org.kc"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name := "sbt-dependency-diff",
    pluginCrossBuild / sbtVersion := {
      scalaBinaryVersion.value match {
        case "2.12" => "1.4.0" // set minimum sbt version
      }
    }
  )
