package com.andersenlab.spaceinv.api.model

import java.util.UUID
import com.andersenlab.spaceinv.model.{PhysicalCharacteristics, StarType}

case class StarView(id: UUID,
                    name: String,
                    characteristics: PhysicalCharacteristics,
                    `type`: StarType.StarType)
