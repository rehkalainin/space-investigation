package com.andersenlab.spaceinv.api.modelView

import java.util.UUID
import com.andersenlab.spaceinv.model.{PhysicalCharacteristics, Star, StarType}

case class StarView(id: UUID,
                    name: String,
                    characteristics: PhysicalCharacteristics,
                    `type`: StarType.StarType)

object StarView {
  def fromStar(star: Star): StarView = {
    StarView(star.id, star.name, star.characteristics, star.`type`)
  }
}