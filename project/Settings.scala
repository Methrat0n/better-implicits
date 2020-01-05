import sbt._
import Keys._

object Settings {
  object scala {
    val crossScalaVersions = Seq("2.12.0", "2.13.0")
    val commonSettings = Seq(
      organization := "io.github.methrat0n",
      scalacOptions := Seq (
        "-encoding", "utf-8",
        "-explaintypes",
        "-deprecation",
        "-unchecked",
        "-feature",
        "-Xcheckinit",
        "-Xfatal-warnings",
        "-Xlint",
        //"-Xlog-implicits"
      ),
    )
  }
}
