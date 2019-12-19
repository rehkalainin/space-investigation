package com.andersenlab.spaceinv
import com.andersenlab.spaceinv.model.StarSystem
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Application {
  def main(args: Array[String]): Unit = {
    println("Hello, space!")
    val starsystem = TableQuery[StarSystem]


    val db = Database.forConfig("mydb")
    try {
      println("quantity connections "+ db.source.maxConnections.get)


    } finally db.close
  }
}
