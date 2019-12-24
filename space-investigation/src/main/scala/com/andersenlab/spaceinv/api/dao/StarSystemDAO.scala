package com.andersenlab.spaceinv.api.dao

import akka.Done
import com.andersenlab.spaceinv.WebServer.{Order, orders}
import com.andersenlab.spaceinv.model.{StarSystem, StarSystemTable}
import slick.lifted.QueryBase

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

case class StarSystemDAO() extends DAO[StarSystem] {

val starSystemDB: QueryBase[Seq[StarSystem]] = StarSystemTable.starSystem


  //#create
  val resultFuture = setupFuture.flatMap { _ =>

    //#readall
    // Read all coffees and print them to the console
    println("Coffees:")
    db.run(coffees.result).map(_.foreach {
      case (name, supID, price, sales, total) =>
        println("  " + name + "\t" + supID + "\t" + price + "\t" + sales + "\t" + total)
    })
    // Equivalent SQL code:
    // select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES
    //#readall

  override def read(id: Long): Future[Option[StarSystem]] = {
    Future {
      starSystemDB.find()
    //  starSystemDB.find(o => o.id == itemId)
    }


  }
}