package com.andersenlab.spaceinv.model

import java.util.UUID
import slick.jdbc.PostgresProfile.api._

case class Planet(id: UUID,
                  name: String,
                  coordinates: Coordinates,
                  starSystemId: UUID,
                  characteristics: PhysicalCharacteristics)
class PlanetTable (tag:Tag) extends Table[Planet](tag, "PLANETTABLE"){
  def id = column[UUID]("PLANET_ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("PLANET_NAME")
  def coordinates = column[Coordinates]("COORDINATES")
  def starSystemId = column[UUID]("STARSYSTEM_ID")
  def characteristics = column[PhysicalCharacteristics]("CHARACTERISTICS")

def * = (id, name, coordinates, starSystemId, characteristics).mapTo[Planet]

  def starSystem = foreignKey("SS_FK", starSystemId, TableQuery[StarSystem])(_.id)
}
