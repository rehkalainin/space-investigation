package com.andersenlab.spaceinv.api.model

import java.util.UUID
import com.andersenlab.spaceinv.model.{PhysicalCharacteristics, Star, StarType}

case class StarView(id: UUID,
                    name: String,
                    characteristics: PhysicalCharacteristics,
                    `type`: StarType.StarType)

object StarView {
  def fromStar(star: Star): StarView = {
    // todo: implement
    ???
  }
}