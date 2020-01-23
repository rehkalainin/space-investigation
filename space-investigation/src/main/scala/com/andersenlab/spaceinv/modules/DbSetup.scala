package com.andersenlab.spaceinv.modules

import java.util.UUID

import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api._
import com.andersenlab.spaceinv.model.{Coordinates, Mass, PhysicalCharacteristics, PlanetTable, Radius, Star, StarSystem, StarSystemTable, StarTable, StarType}

import scala.concurrent.Await
import scala.concurrent.duration._

object DbSetup {
  lazy val db = Database.forConfig("mydb")

  sys.addShutdownHook {
    db.close()
  }

  def setup(): Unit = {
    println("Hello, space!")
    println("quantity connections " + db.source.maxConnections.get)

    val STARSYSTEMID_SOLAR = UUID.randomUUID()
    val STARSYSTEMID_SIRIUS = UUID.randomUUID()
    val STARSYSTEMID_ALFACENTAVRA = UUID.randomUUID()

    val setup = DBIO.seq(
      (StarSystemTable.starSystem.schema ++ StarTable.star.schema ++ PlanetTable.planet.schema).create,

      StarSystemTable.starSystem += StarSystem(STARSYSTEMID_SOLAR, "SolarSystem"),
      StarSystemTable.starSystem += StarSystem(STARSYSTEMID_SIRIUS, "Syrius"),
      StarSystemTable.starSystem += StarSystem(STARSYSTEMID_ALFACENTAVRA, "AlfaCentavra"),


      StarTable.star ++= Seq(
        Star(UUID.randomUUID(), "Solar", STARSYSTEMID_SOLAR, PhysicalCharacteristics(Mass(2000), Radius(10000), Coordinates(2.1, 2.2, 2.3)), StarType.LikeSun.toString),
        Star(UUID.randomUUID(), "SiriusA", STARSYSTEMID_SIRIUS, PhysicalCharacteristics(Mass(4000), Radius(15000), Coordinates(3.1, 4.2, 5.3)), StarType.LikeSun.toString),
        Star(UUID.randomUUID(), "SiriusB", STARSYSTEMID_SIRIUS, PhysicalCharacteristics(Mass(5000), Radius(20000), Coordinates(4.1, 5.2, 6.3)), StarType.LikeSun.toString),
        Star(UUID.randomUUID(), "AlfaA", STARSYSTEMID_ALFACENTAVRA, PhysicalCharacteristics(Mass(7000), Radius(80000), Coordinates(5.1, 7.2, 7.3)), StarType.LikeSun.toString),

      )
    )

    val setupFuture = db.run(setup.transactionally)
    Await.result(setupFuture, 2.second)
  }
}
