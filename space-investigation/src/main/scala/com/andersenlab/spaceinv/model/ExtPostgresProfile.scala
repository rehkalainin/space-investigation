package com.andersenlab.spaceinv.model

import slick.jdbc.PostgresProfile

object ExtPostgresProfile extends PostgresProfile {
  trait MyApi extends API {
    implicit val massColumnType = MappedColumnType.base[Mass, Double](_.kilos, Mass)
    implicit val starTypeColumnType = enumColumnType(StarType)

    private def enumColumnType(enum: Enumeration) = {
      MappedColumnType.base[enum.Value, String](_.toString, enum.withName)
    }
  }

  override val api: MyApi = new MyApi {}
}
