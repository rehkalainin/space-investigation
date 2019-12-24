package com.andersenlab.spaceinv.api.dao

import akka.Done
import com.andersenlab.spaceinv.model.ExtPostgresProfile.api._
import scala.concurrent.Future

trait DAO[T] {
  val db = Database.forConfig("mydb")

  def read (id: Long): Future[Option[T]]
  def create (element: T): Future[Done]
//  def readAll: Future[Option[List[T]]]
//  def update (element : T): Future[Done]
//  def delete (id: Long): Future[Done]



}
