package org.kc.sbtdependencydiff

import sbt._

/** This plugin is automatically enabled for all projects. It defines settings and tasks that are
  * automatically imported to the user scope. To enable this plugin, use
  * `enablePlugins(HelloPlugin)` in your sbt file. To disable this plugin, use
  * `disablePlugins(HelloPlugin)` in your sbt file. To change the default behavior, use
  * `HelloPlugin.autoImport.*` in your sbt file.
  * @see
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Best-Practices.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Templates.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Overview.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Getting-Started.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Howto.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Community-Plugins.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Developing.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Testing.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Setup.html]]
  *   [[http://www.scala-sbt.org/1.x/docs/Plugins-Using.html]]
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
      val streams = Keys.streams.value
      val greeting = helloGreeting.value
      streams.log.info(greeting)
    }
  )
}
