package com.andersenlab.spaceinv.api.request

import com.andersenlab.spaceinv.model.PhysicalCharacteristics
import com.andersenlab.spaceinv.model.StarType.StarType

case class CreateStarRequest(name: String,
                             characteristics: PhysicalCharacteristics,
                             `type`: StarType)
