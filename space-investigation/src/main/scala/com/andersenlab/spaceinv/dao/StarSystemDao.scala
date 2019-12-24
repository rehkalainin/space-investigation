package com.andersenlab.spaceinv.dao

import java.util.UUID
import ExtPostgresProfile.api._
import cats.data.NonEmptyList
import com.andersenlab.spaceinv.api.model.{PlanetView, StarSystemView, StarView}
import com.andersenlab.spaceinv.model.{PlanetTable, StarSystemTable, StarTable}
import scala.concurrent.ExecutionContext

trait StarSystemDao {
  def findStarSystem(starSystemId: UUID): DBIO[Option[StarSystemView]]

  def listAll(): DBIO[List[StarSystemView]]
}

class StarSystemDaoImpl(implicit ec: ExecutionContext) extends StarSystemDao {
  override def findStarSystem(starSystemId: UUID): DBIO[Option[StarSystemView]] = {
    val starSystemDBIO = StarSystemTable
      .starSystem
      .filter(_.id === starSystemId.bind)
      .result.headOption

    starSystemDBIO.flatMap {
      case None             => DBIO.successful(None)
      case Some(starSystem) =>
        for {
          stars <- StarTable.star.filter(_.starSystemId === starSystemId.bind).to[List].result
          planets <- PlanetTable.planet.filter(_.starSystemId === starSystemId.bind).to[List].result
        } yield {
          NonEmptyList.fromList(stars).map { nonEmptyStars =>
            StarSystemView(
              starSystemId,
              starSystem.name,
              nonEmptyStars.map(StarView.fromStar),
              planets.map(PlanetView.fromPlanet)
            )
          }
        }
    }
  }

  override def listAll(): DBIO[List[StarSystemView]] = {
    // todo: implement
    ???
  }
}
