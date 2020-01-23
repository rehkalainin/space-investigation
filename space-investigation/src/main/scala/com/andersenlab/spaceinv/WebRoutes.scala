package com.andersenlab.spaceinv

import akka.http.scaladsl.server.{Route, RouteConcatenation}
import com.andersenlab.spaceinv.modules.{PlanetModul, StarModule, StarSystemModule}

object WebRoutes {
  def route: Route = {
    RouteConcatenation.concat(
      StarSystemModule.starSystemController.route,
      StarModule.starController.route,
      PlanetModul.planetController.route
    )
  }
}
