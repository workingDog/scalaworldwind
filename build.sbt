sbtPlugin := true

name := "scala-worldwind"

organization := "com.kodekutters"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += Opts.resolver.sonatypeSnapshots

libraryDependencies ++= Seq(
  "org.scalafx" % "scalafx_2.11" % "8.0.31-R7"
)

