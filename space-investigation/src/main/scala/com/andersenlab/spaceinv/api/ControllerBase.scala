package com.andersenlab.spaceinv.api

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives

trait ControllerBase extends Directives {
  def route: Route

  val apiV1 = pathPrefix("api" / "v1")
}
