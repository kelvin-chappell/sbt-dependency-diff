package org.kc.sbtdependencydiff

import sbt.*
import sbt.Def.spaceDelimited
import sbt.Keys.*
import sbt.plugins.DependencyTreeKeys.dependencyList
import sbt.plugins.{DependencyTreeKeys, DependencyTreePlugin, MiniDependencyTreePlugin}

object HelloPlugin extends AutoPlugin {

  // By defining autoImport, the settings are automatically imported into user's `*.sbt`
  object autoImport extends DependencyTreeKeys {
    // Configuration points, like the built-in `version`, `libraryDependencies`, or `compile`
    val sayHello = inputKey[Unit]("Prints out a greeting.")
  }

//  import autoImport.*

  override def requires: Plugins = DependencyTreePlugin

  // This plugin is automatically enabled
  override def trigger: PluginTrigger = allRequirements

  val configurations = Vector(Compile, Test, Runtime, Default, Provided, Optional)

  // TODO: in plugin code, generate module graph of dependencies of current code
  // ???

  // TODO: in plugin code, generate module graph of dependencies of code from another ref
  // ???

}
