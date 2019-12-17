package com.andersenlab.spaceinv
import slick.jdbc.PostgresProfile.api._
import scala.concurrent.{Future,Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Application {
  def main(args: Array[String]): Unit = {
    println("Hello, space!")

  }
}
