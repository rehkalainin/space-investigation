package com.andersenlab.spaceinv.model

import java.util.UUID
import ExtPostgresProfile.api._

object StarType extends Enumeration {
  type StarType = Value

  val SuperNova, WhiteDwarf, RedGiant, BlackHole, LikeSun = Value
}

case class Star(id: UUID,
                name: String,
                starSystemId: UUID,
                characteristics: PhysicalCharacteristics,
               `type`: StarType.StarType)

class StarTable (tag:Tag) extends Table[Star](tag, "STAR"){
  def id = column[UUID]("STAR_ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("STAR_NAME")
  def starSystemId = column[UUID]("STARSYSTEM_ID")
  def characteristics = column[PhysicalCharacteristics]("CHARACTERISTICS")
  def `type` = column[StarType.StarType]("STAR_TYPE")
}

object StarTable {
  val query = TableQuery[StarTable]
}