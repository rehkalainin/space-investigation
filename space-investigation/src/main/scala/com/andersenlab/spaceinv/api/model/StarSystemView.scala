package com.andersenlab.spaceinv.api.model

import java.util.UUID
import cats.data.NonEmptyList

case class StarSystemView(starSystemId: UUID,
                          stars: NonEmptyList[StarView],
                          planets: List[PlanetView])
