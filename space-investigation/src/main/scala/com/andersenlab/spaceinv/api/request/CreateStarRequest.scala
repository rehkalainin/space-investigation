package com.andersenlab.spaceinv.api.request

import com.andersenlab.spaceinv.model.PhysicalCharacteristics

case class CreateStarRequest(name: String,
                             characteristics: PhysicalCharacteristics,
                             `type`: String)
