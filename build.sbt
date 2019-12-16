import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.10",
  libraryDependencies ++= Seq(
    scalatest % "test",
    scalactic % "test",
    catsCore
  ),
  scalacOptions += "-Ypartial-unification"
)

lazy val `space-investigation` = project.in(file("space-investigation"))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
      // todo: add akka-http, circe, slick, etc.
    )
  )

lazy val root = project.in(file("."))
  .settings(commonSettings)
  .aggregate(
    `space-investigation`
  )
