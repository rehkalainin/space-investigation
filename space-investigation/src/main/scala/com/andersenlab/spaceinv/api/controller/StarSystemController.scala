package com.andersenlab.spaceinv.api.controller

import java.util.UUID

import akka.http.scaladsl.server.Route
import com.andersenlab.spaceinv.api.request.CreateStarSystemRequest
import com.andersenlab.spaceinv.api.service.StarSystemService
import com.andersenlab.spaceinv.model.StarSystem
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport._
import io.circe.generic.auto._
import io.circe.syntax._


class StarSystemController(starSystemService: StarSystemService) extends ControllerBase {


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
        } ~ pathEndOrSingleSlash {
          saveStarSystemRoute() ~
            updateStarSystemRoute()
        }
      } ~ pathPrefix("new_starsystem") {
        pathEndOrSingleSlash {
          saveFullStarSystemRoute()
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

  private def saveStarSystemRoute(): Route = {
    post {
      entity(as[StarSystem]) {
        starSystem =>
          onSuccess(starSystemService.saveStarSystem(starSystem)) {
            complete("created starsystem ")
          }
      }
    }
  }

  def updateStarSystemRoute(): Route = {
    put {
      entity(as[StarSystem]) {
        starSystem =>
          onSuccess(starSystemService.updateStarSystem(starSystem)) {
            complete("update starsystem")
          }
      }
    }
  }

  def saveFullStarSystemRoute(): Route = {
    post {
      entity(as[CreateStarSystemRequest]) { request =>
        onSuccess(starSystemService.saveDetailStarSystem(request)) {
          complete("created detail starsystem")
        }
      }
    }
  }
}
