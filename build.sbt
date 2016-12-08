name           := "MyScalaColliderApp"
version        := "0.1.0-SNAPSHOT"
organization   := "doe.jane"
scalaVersion   := "2.11.8"
licenses       := Seq("LGPL v2.1+" -> url("http://www.gnu.org/licenses/lgpl-2.1.txt"))

libraryDependencies ++= Seq(
  "de.sciss" %% "scalacollider" % "1.22.2",
  "org.scala-lang.modules" %% "scala-swing" % "1.0.2"
)

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8", "-Xfuture")

// bundling

assemblyJarName in assembly := s"${name.value}.jar"

target in assembly := baseDirectory.value
