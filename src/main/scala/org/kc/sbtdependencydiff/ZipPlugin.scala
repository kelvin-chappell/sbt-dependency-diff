package org.kc.sbtdependencydiff

import sbt._

/** This plugin is automatically enabled for all projects. It defines settings and tasks that are
  * automatically imported to the user scope. See
  * https://medium.com/@phkadam2008/write-test-your-own-scala-sbt-plugin-6701b0e36a62
  */
object ZipPlugin extends AutoPlugin {
  override def trigger = allRequirements
  override def requires = plugins.JvmPlugin

  object autoImport {
    val sourceZipDir = settingKey[File]("source directory to generate zip from.")
    val targetZipDir = settingKey[File]("target directory to store generated zip.")
    val zip = taskKey[Unit]("Generates zip file which includes all files from sourceZipDir")
  }

  import autoImport._

  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    sourceZipDir := Keys.sourceDirectory.value,
    targetZipDir := Keys.target.value / "zip",
    zip := zipTask.value
  )

  def zipTask = Def.task {
    val log = Keys.sLog.value
    lazy val zip = new File(targetZipDir.value, sourceZipDir.value.getName + ".zip")
    log.info("Zipping file...")
    IO.zip(Path.allSubpaths(sourceZipDir.value), zip)
    zip
  }
}
