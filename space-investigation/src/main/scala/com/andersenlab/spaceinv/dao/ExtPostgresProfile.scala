package com.andersenlab.spaceinv.dao

import com.andersenlab.spaceinv.model.{Mass, Radius, StarType}
import slick.jdbc.PostgresProfile

trait ExtPostgresProfile extends PostgresProfile {
  trait MyApi extends API {
    implicit val massColumnType = MappedColumnType.base[Mass, Double](_.kilos, Mass)
    implicit val starTypeColumnType = enumColumnType(StarType)
    implicit val radiusColumnType = MappedColumnType.base[Radius, Double](_.kilometers, Radius)

    private def enumColumnType(enum: Enumeration) = {
      MappedColumnType.base[enum.Value, String](_.toString, enum.withName(_))
    }
  }

  override val api: MyApi = new MyApi {}
}
object ExtPostgresProfile extends ExtPostgresProfile
