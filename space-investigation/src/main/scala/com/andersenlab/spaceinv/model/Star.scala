package com.andersenlab.spaceinv.model

import java.util.UUID

object StarType extends Enumeration {
  type StarType = Value

  val SuperNova, RedGiant, SunLike = Value
}

case class Star(id: UUID,
                name: String,
                starSystemId: UUID,
                characteristics: PhysicalCharacteristics,
               `type`: StarType.StarType)
