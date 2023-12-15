package org.kc.sbtdependencydiff

import sbt.*
import sbt.internal.graph.rendering.FlatList
import sbt.util.Input

/** This plugin is automatically enabled for all projects. It defines settings and tasks that are
  * automatically imported to the user scope.
  */
object DependencyDiffPlugin extends AutoPlugin {
  override def trigger = allRequirements
//  override def requires = plugins.MiniDependencyTreePlugin

  object autoImport {
    val diffRef = settingKey[Input]("Github ref to diff against")
    val diff = taskKey[Unit]("Diff dependency lists")
  }

  import autoImport._

  override lazy val projectSettings: Seq[Setting[_]] = ???
}

object DependencyDiff {
  def render(): String = {
    val show = ???
    val graph = ???
    FlatList.render(show)(graph)
  }
}
