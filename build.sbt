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
      "com.typesafe.slick" %% "slick" % "3.3.2",
      "org.slf4j" % "slf4j-nop" % "1.7.26",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.1"
      // todo: add akka-http, circe, slick, etc.
    )
  )

lazy val root = project.in(file("."))
  .settings(commonSettings)
  .aggregate(
    `space-investigation`
  )

