package com.andersenlab.spaceinv

import akka.http.scaladsl.server.{Route, RouteConcatenation}
import com.andersenlab.spaceinv.modules.StarSystemModule

object WebRoutes {
  def route: Route = {
    RouteConcatenation.concat(
      StarSystemModule.controller.route
    )
  }
}
