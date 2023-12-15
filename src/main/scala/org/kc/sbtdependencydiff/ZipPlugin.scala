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
    zip := Zip(sourceZipDir.value, targetZipDir.value, Keys.sLog.value)
  )
}

object Zip {
  def apply(sourceDir: File, targetDir: File, logger: Logger): File = {
    val zip = new File(targetDir, sourceDir.getName + ".zip")
    logger.info(s"Source directory: $sourceDir")
    logger.info(s"Target file: $zip")
    logger.info("Zipping file...")
    IO.zip(Path.allSubpaths(sourceDir), zip, time = None)
    zip
  }
}
