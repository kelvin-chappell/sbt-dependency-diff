package org.kc.sbtdependencydiff

import sbt.{File, settingKey, taskKey}

trait ZipKeys {
    lazy val sourceZipDir = settingKey[File]("source directory to generate zip from.")
    lazy val targetZipDir = settingKey[File]("target directory to store generated zip.")
    lazy val zip = taskKey[Unit]("Generates zip file which includes all files from sourceZipDir")
}
