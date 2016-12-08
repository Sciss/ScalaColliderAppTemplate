![logo](https://raw.githubusercontent.com/Sciss/ScalaColliderAppTemplate/master/src/main/resources/doe/john/myscalacolliderapp/icon.png)

# ScalaCollider Template App

## statement

This is a template to make a [ScalaCollider](https://sciss.github.io/ScalaCollider) based application.
It assumes that SuperCollider (scsynth) is independently installed on the system.

The project is made available under the GNU Lesser General Public License v2.1 (or newer), the
same as the most recent version of ScalaCollider.

Simply open `MyScalaColliderApp.scala` and add your own code.

To run via sbt, simply execute `sbt run`. To build a standalone application, run `sbt assembly`.
The resulting jar can be executed via `java -jar MyScalaColliderApp.jar`.

We have include the `sbt` script from [paulp](https://github.com/paulp/sbt-extras) which uses a BSD-style license, so if you do
not want to install sbt, you can just execute `./sbt run`.
