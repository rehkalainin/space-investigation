package com.andersenlab.spaceinv

import com.andersenlab.spaceinv.modules.CoreExecutionProfile._
import akka.http.scaladsl.Http
import com.andersenlab.spaceinv.modules.DbSetup

object Application {
  def main(args: Array[String]): Unit = {
    //DbSetup.setup()

    val binding = Http().bindAndHandle(WebRoutes.route, interface = "localhost", port = 8080)

    actorSystem.registerOnTermination {
      binding.flatMap(_.unbind())
    }
  }
}
