# sbt-dependency-diff

## Create plugin
1. Extend autoplugin
2. Define trigger
3. Use autoImport to hold new keys
4. Define settings

## Publish plugin
1. publishLocal

## Use plugin
1. Add plugin to project/plugins.sbt
2. Enable plugin in build.sbt (if it isn't a triggered plugin)
3. Run tasks

## Links
* https://www.scala-sbt.org/1.x/docs/Task-Graph.html#Terminology
* https://www.scala-sbt.org/1.x/docs/Basic-Def.html#What+is+a+build+definition%3F
* https://www.scala-sbt.org/1.x/docs/Basic-Def.html#Types
* https://www.scala-sbt.org/1.x/docs/Plugins.html#Creating+an+auto+plugin
