package com.andersenlab.spaceinv.model

import java.util.UUID

case class Planet(id: UUID,
                  name: String,
                  coordinates: Coordinates,
                  starSystemId: UUID,
                  characteristics: PhysicalCharacteristics)
