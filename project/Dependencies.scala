import sbt.librarymanagement.syntax._

object Dependencies {
  val scalatestVersion = "3.0.1"
  val catsVersion = "2.0.0"
  val slickVerion = "3.3.1"
  val slf4jVersion = "1.7.26"
  val postgresDriverVersion = "42.2.5"
  val akkaHttpVersion = "10.1.11"
  val akkaStreamVersion = "2.5.26"
  val jsonVersion = "10.1.7"
  val circeVersion = "0.12.3"
  val mockitoVersion = "1.0.0"

  val scalactic = "org.scalactic" %% "scalactic" % scalatestVersion
  val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion
  val mockito = "org.mockito" %% "mockito-scala" % mockitoVersion

  val catsCore = "org.typelevel" %% "cats-core" % catsVersion
  val slick = "com.typesafe.slick" %% "slick" % slickVerion
  val slickHikari = "com.typesafe.slick" %% "slick-hikaricp" % slickVerion
  val slf4jNop = "org.slf4j" % "slf4j-nop" % slf4jVersion
  val postgresDriver = "org.postgresql" % "postgresql" % postgresDriverVersion
  val akkaHttp = "com.typesafe.akka" %% "akka-http"   % akkaHttpVersion
  val akkaStreams = "com.typesafe.akka" %% "akka-stream" % akkaStreamVersion
  val json = "com.typesafe.akka" %% "akka-http-spray-json" % jsonVersion
  val circeCore = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val circeParser = "io.circe" %% "circe-parser" % circeVersion

}
