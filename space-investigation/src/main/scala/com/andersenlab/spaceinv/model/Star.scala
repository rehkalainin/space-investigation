package com.andersenlab.spaceinv.model

import java.util.UUID
import ExtPostgresProfile.api._

object StarType extends Enumeration {
  type StarType = Value

  val SuperNova, WhiteDwarf, RedGiant, BlackHole, LikeSun, NeitronStar = Value
}

case class Star(id: UUID,
                name: String,
                starSystemId: UUID,
                characteristics: PhysicalCharacteristics,
               `type`: StarType.StarType)

class StarTable (tag:Tag) extends Table[Star](tag, "STAR") with PhysicalCharacteristicsColumns {
  def id = column[UUID]("STAR_ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("STAR_NAME")
  def starSystemId = column[UUID]("STARSYSTEM_ID")

//  def xAxis = column[Double]("X_Axis")
//  def yAxis = column[Double]("Y_Axis")
//  def zAxis = column[Double]("Z_Axis")
//
//  def coordinates = (xAxis,yAxis,zAxis).mapTo[Coordinates]
//
//  def mass =column[Mass]("Mass")
//  def radius = column[Radius]("Radius")
//
//  def characteristics = (mass, radius,coordinates).mapTo[PhysicalCharacteristics]

  def `type` = column[StarType.StarType]("STAR_TYPE")

  def star = foreignKey("STAR_FK", starSystemId, TableQuery[StarTable])(_.id)

  override def * = (id,name, starSystemId,characteristics,`type`).mapTo[Star]
}

object StarTable {
  val star = TableQuery[StarTable]
}