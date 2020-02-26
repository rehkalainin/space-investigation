import Dependencies._

lazy val commonSettings = Seq(
  version := "0.1",
  scalaVersion := "2.12.10",
  scalacOptions += "-Ypartial-unification"
)

lazy val `space-investigation` = project.in(file("space-investigation"))
  .settings(
    libraryDependencies ++= Seq(
      scalatest % "test",
      scalactic % "test",
      slick,
      slickHikari,
      slf4jNop,
      catsCore,
      postgresDriver,
      akkaHttp,
      akkaStreams,
      json,
      circeCore,
      circeGeneric,
      circeParser,
      mockito,
      akkaHttpCirce,
      circeJava,
      mock,
      testconteinersPostgresql
    )
  )

lazy val root = project.in(file("."))
  .settings(commonSettings)
  .aggregate(
    `space-investigation`
  )

