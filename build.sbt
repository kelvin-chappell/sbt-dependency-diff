organization := "org.kc"
name := "sbt-dependency-diff"
version := "0.1.5-SNAPSHOT"

scalaVersion := "2.12.18"

sbtPlugin := true

libraryDependencies += "org.scala-sbt" % "sbt-dependency-tree_2.12_1.0" % sbtVersion.value
