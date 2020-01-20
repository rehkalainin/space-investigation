package com.andersenlab.spaceinv

import akka.http.scaladsl.server.{Route, RouteConcatenation}
import com.andersenlab.spaceinv.modules.{StarModule, StarSystemModule}

object WebRoutes {
  def route: Route = {
    RouteConcatenation.concat(
      StarSystemModule.starSystemController.route,
      StarModule.starController.route
    )
  }
}
