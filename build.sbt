resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies += "io.spray" %% "spray-json" % "1.2.6"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"