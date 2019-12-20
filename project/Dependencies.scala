import sbt.librarymanagement.syntax._

object Dependencies {
  val scalatestVersion = "3.0.1"
  val catsVersion = "2.0.0"
  val slickVerion = "3.3.1"
  val slf4jVersion = "1.7.26"
  val postgresDriverVersion = "42.2.5"

  val scalactic = "org.scalactic" %% "scalactic" % scalatestVersion
  val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion

  val catsCore = "org.typelevel" %% "cats-core" % catsVersion
  val slick = "com.typesafe.slick" %% "slick" % slickVerion
  val slickHikari = "com.typesafe.slick" %% "slick-hikaricp" % slickVerion
  val slf4jNop = "org.slf4j" % "slf4j-nop" % slf4jVersion
  val postgresDriver = "org.postgresql" % "postgresql" % postgresDriverVersion
}
