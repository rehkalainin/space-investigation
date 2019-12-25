package com.andersenlab.spaceinv.model

import java.util.UUID
import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api._

case class Planet(id: UUID,
                  name: String,
                  coordinates: Coordinates,
                  starSystemId: UUID,
                  characteristics: PhysicalCharacteristics)

class PlanetTable(tag: Tag) extends Table[Planet](tag, "PLANETTABLE") with PhysicalCharacteristicsColumns {
  def id = column[UUID]("PLANET_ID", O.PrimaryKey)
  def name = column[String]("PLANET_NAME")
  def starSystemId = column[UUID]("STARSYSTEM_ID")

  def planet = foreignKey("PLANET_FK", starSystemId, PlanetTable.planet)(_.id)

  def * = (id, name, coordinates, starSystemId, characteristics).mapTo[Planet]
}

object PlanetTable {
  val planet = TableQuery[PlanetTable]
}