package com.andersenlab.spaceinv.model

import java.util.UUID
import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api._
import com.andersenlab.spaceinv.model.StarType.StarType
import io.circe._

object StarType extends Enumeration {
  type StarType = Value

  val SuperNova, WhiteDwarf, RedGiant, BlackHole, LikeSun, NeitronStar = Value

  implicit val starTypeDecoder = Decoder.decodeEnumeration(this)
  implicit val starTypeEncoder = Encoder.encodeEnumeration(this)
}

case class Star(id: UUID,
                name: String,
                starSystemId: UUID,
                characteristics: PhysicalCharacteristics,
                `type`: StarType)

class StarTable(tag: Tag) extends Table[Star](tag, "STAR") with PhysicalCharacteristicsColumns {
  def id = column[UUID]("STAR_ID", O.PrimaryKey)

  def name = column[String]("STAR_NAME")

  def starSystemId = column[UUID]("STARSYSTEM_ID")

  def `type` = column[StarType]("STAR_TYPE")

  def star = foreignKey("STAR_FK", starSystemId, StarSystemTable.starSystem)(_.id)

  override def * = (id, name, starSystemId, characteristics, `type`).mapTo[Star]
}

object StarTable {
  val star = TableQuery[StarTable]
}