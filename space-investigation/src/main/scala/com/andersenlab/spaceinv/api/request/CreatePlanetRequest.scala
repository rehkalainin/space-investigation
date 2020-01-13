package com.andersenlab.spaceinv.api.request

import com.andersenlab.spaceinv.model.{Coordinates, PhysicalCharacteristics}

case class CreatePlanetRequest(name: String,
                          coordinates: Coordinates,
                          characteristics: PhysicalCharacteristics)
