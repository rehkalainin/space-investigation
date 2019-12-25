package com.andersenlab.spaceinv.api

import java.util.UUID
import akka.http.scaladsl.server.Route
import com.andersenlab.spaceinv.api.service.StarSystemService

class StarSystemController(starSystemService: StarSystemService) extends ControllerBase {

  // todo:

  // GET view planet: PlanetView

  // POST create planet: Planet

  // PUT updated planet: Planet


  // same for Star

  // same for StarSystem
  def route: Route = {
    apiV1 {
      pathPrefix("systems") {
        path("list") {
          pathEndOrSingleSlash {
            listAll()
          }
        } ~ path(JavaUUID) { starSystemId =>
          pathEndOrSingleSlash {
            findStarSystemRoute(starSystemId)
          }
        }
      }
    }
  }

  private def findStarSystemRoute(starSystemId: UUID): Route = {
    get {
      onSuccess(starSystemService.findStarSystem(starSystemId)) {
        case None => complete("NOT FOUND")
        case Some(starSystem) => complete(starSystem.toString)
      }
    }
  }

  private def listAll(): Route = {
    get {
      onSuccess(starSystemService.listAll()) { list =>
        complete(list mkString "\n")
      }
    }
  }
}
