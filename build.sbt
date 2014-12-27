name           := "MyScalaColliderApp"

version        := "0.1.0-SNAPSHOT"

organization   := "doe.john"

scalaVersion   := "2.11.4"

licenses       := Seq("GPL v2+" -> url("http://www.gnu.org/licenses/gpl-2.0.txt"))

libraryDependencies ++= Seq(
  "de.sciss" %% "scalacollider" % "1.15.0",
  "org.scala-lang.modules" %% "scala-swing" % "1.0.1"
)

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8", "-Xfuture")

// bundling

assemblyJarName in assembly := s"${name.value}.jar"

target in assembly := baseDirectory.value
