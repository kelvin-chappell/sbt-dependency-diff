package org.kc.sbtdependencydiff

import sbt._

/** This plugin is automatically enabled for all projects. It defines settings and tasks that are
  * automatically imported to the user scope. See
  * https://www.scala-sbt.org/1.x/docs/Plugins.html#Creating+an+auto+plugin
  */
object HelloPlugin extends AutoPlugin {
  override def trigger = allRequirements

  object autoImport {
    val helloGreeting = settingKey[String]("greeting")
    val hello = taskKey[Unit]("say hello")
  }

  import autoImport._

  override lazy val globalSettings: Seq[Setting[_]] = Seq(
    helloGreeting := "hi"
  )

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    hello := {
      val log = Keys.sLog.value
      val greeting = helloGreeting.value
      log.info(greeting)
    }
  )
}
