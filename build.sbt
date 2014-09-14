resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

scalaVersion := "2.11.2"

libraryDependencies += "io.spray" %% "spray-json" % "1.2.6"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"