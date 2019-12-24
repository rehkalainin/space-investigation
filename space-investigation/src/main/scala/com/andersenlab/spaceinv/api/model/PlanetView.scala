package com.andersenlab.spaceinv.api.model

import java.util.UUID
import com.andersenlab.spaceinv.model.{Coordinates, PhysicalCharacteristics, Planet}

case class PlanetView(id: UUID,
                      name: String,
                      coordinates: Coordinates,
                      characteristics: PhysicalCharacteristics)

object PlanetView {
  def fromPlanet(planet: Planet): PlanetView = {
    // todo: implement
    ???
  }
}