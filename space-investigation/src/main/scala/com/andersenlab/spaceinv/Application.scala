package com.andersenlab.spaceinv

import akka.http.scaladsl.Http
import com.andersenlab.spaceinv.modules.CoreExecutionProfile._

import scala.concurrent.Future

object Application {
  def main(args: Array[String]): Unit = {
    //DbSetup.setup()

    val binding: Future[Http.ServerBinding] = Http().bindAndHandle(WebRoutes.route, interface = "localhost", port = 8080)

    actorSystem.registerOnTermination {
      binding.flatMap(_.unbind())
    }
  }
}
