package com.andersenlab.spaceinv.model

import java.util.UUID
import ExtPostgresProfile.api._

case class Planet(id: UUID,
                  name: String,
                  coordinates: Coordinates,
                  starSystemId: UUID,
                  characteristics: PhysicalCharacteristics)

class PlanetTable(tag: Tag) extends Table[Planet](tag, "PLANETTABLE") {
  def id = column[UUID]("PLANET_ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("PLANET_NAME")
  def starSystemId = column[UUID]("STARSYSTEM_ID")

  def xAxis = column[Double]("X_AXIS")
  def yAxis = column[Double]("Y_AXIS")
  def zAxis = column[Double]("Z_AXIS")

  def mass = column[Mass]("MASS")
  def radius = column[Radius]("RADIUS")


  def coordinates = (xAxis, yAxis, zAxis).mapTo[Coordinates]

  def characteristics = (mass, radius, coordinates).mapTo[PhysicalCharacteristics]


  def * = (id, name, coordinates, starSystemId, characteristics).mapTo[Planet]
}

object PlanetTable {
  val query = TableQuery[PlanetTable]
}