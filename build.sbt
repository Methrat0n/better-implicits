lazy val scalaReflect = Def.setting { "org.scala-lang" % "scala-reflect" % "2.12.0" }
lazy val diff = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "better-implicits",
    libraryDependencies += scalaReflect.value
  )


lazy val commonSettings =
  Settings.scala.commonSettings ++
    scalariformCommonSettings

import scalariform.formatter.preferences._

lazy val scalariformCommonSettings = Seq(
  scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(CompactControlReadability, true)
    .setPreference(DanglingCloseParenthesis, Force)
    .setPreference(IndentLocalDefs, true)
    .setPreference(NewlineAtEndOfFile, true)
)

ThisBuild / organization := "io.github.methrat0n"
ThisBuild / organizationName := "methrat0n"
ThisBuild / organizationHomepage := Some(url("https://methrat0n.github.io/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.io/methrat0n/restruct"),
    "scm:git@github.io:methrat0n/restruct.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "methrat0n",
    name  = "Merlin Goulet",
    email = "merlin.goulet@live.fr",
    url   = url("https://methrat0n.github.io/")
  )
)

ThisBuild / description := "Implicit utilities as there should be in Predef"
ThisBuild / licenses := List("MIT" -> new URL("https://github.com/Methrat0n/better-implicits/blob/master/LICENSE"))
ThisBuild / homepage := Some(url("https://methrat0n.github.io/"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  //if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  /*else*/ Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true

isSnapshot := true