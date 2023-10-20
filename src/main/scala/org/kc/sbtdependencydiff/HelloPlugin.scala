package org.kc.sbtdependencydiff

import net.virtualvoid.sbt.graph.DependencyGraphKeys.dependencyList
import sbt.*
import sbt.Def.spaceDelimited
import sbt.Keys.*

object HelloPlugin extends AutoPlugin {

  // By defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport extends ZipKeys {
    // Configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    val sayHello = inputKey[Unit]("Prints out a greeting.")
  }

  import autoImport.*

  override def requires: Plugins = net.virtualvoid.sbt.graph.DependencyGraphPlugin

  // This plugin is automatically enabled
  override def trigger: PluginTrigger = allRequirements

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    sayHello := {
      val args: Seq[String] = spaceDelimited().parsed
      println(s"Hello ${args.headOption.getOrElse("World")}")
      val list = dependencyList.value
//      println(list)
    }
//    sayHello := depListTask.value
  )

  private def depListTask = Def.taskDyn {

    val log = sLog.value
    val args: Seq[String] = spaceDelimited().parsed
    log.info(s"Hello ${args.headOption.getOrElse("World")}")
    log.info("Listing...")
    val list = dependencyList.value
  }

  private def zipTask = Def.task {
    val log = sLog.value
    lazy val zip = new File(targetZipDir.value, sourceZipDir.value.getName + ".zip")
    log.info("Zipping file...")
    IO.zip(Path.allSubpaths(sourceZipDir.value), zip)
    zip
  }
}
