import sbt.librarymanagement.syntax._

object Dependencies {
  val scalatestVersion = "3.0.1"
  val catsVersion = "2.0.0"

  val scalactic = "org.scalactic" %% "scalactic" % scalatestVersion
  val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion

  val catsCore = "org.typelevel" %% "cats-core" % catsVersion
  // todo: define dependencies here
}
