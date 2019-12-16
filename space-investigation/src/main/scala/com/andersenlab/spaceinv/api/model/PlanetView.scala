package com.andersenlab.spaceinv.api.model

import java.util.UUID
import com.andersenlab.spaceinv.model.{Coordinates, PhysicalCharacteristics}

case class PlanetView(id: UUID,
                      name: String,
                      coordinates: Coordinates,
                      characteristics: PhysicalCharacteristics)
