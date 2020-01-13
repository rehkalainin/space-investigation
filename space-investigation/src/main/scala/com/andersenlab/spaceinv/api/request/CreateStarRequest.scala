package com.andersenlab.spaceinv.api.request

import com.andersenlab.spaceinv.model.{PhysicalCharacteristics, StarType}

case class CreateStarRequest(name: String,
                             characteristics: PhysicalCharacteristics,
                             `type`: StarType.StarType)
