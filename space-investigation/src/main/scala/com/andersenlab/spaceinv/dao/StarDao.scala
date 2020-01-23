package com.andersenlab.spaceinv.dao

import java.util.UUID

import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api._
import com.andersenlab.spaceinv.model.{Star, StarTable}
import slick.dbio.DBIO

import scala.concurrent.ExecutionContext


trait StarDao {
  def findStarById(starId: UUID): DBIO[Option[Star]]

  def listAll(): DBIO[List[Star]]

  def saveStar(star: Star): DBIO[Int]

  def updateStar(star: Star): DBIO[Int]

}

class StarDaoImpl(implicit val ec: ExecutionContext) extends StarDao {

  override def findStarById(starId: UUID): DBIO[Option[Star]] = {
    StarTable
      .star
      .filter(_.id === starId.bind)
      .result.headOption
  }

  override def listAll(): DBIO[List[Star]] = {
    StarTable.star.to[List].result
  }

  override def saveStar(star: Star): DBIO[Int] = {
    StarTable.star += star
  }

  override def updateStar(star: Star): DBIO[Int] = {
    StarTable.star.filter(_.id === star.id).update(star)
  }
}
