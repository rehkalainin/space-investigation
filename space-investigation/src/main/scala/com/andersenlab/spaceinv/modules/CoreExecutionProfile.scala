package com.andersenlab.spaceinv.modules

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import scala.concurrent.ExecutionContext

object CoreExecutionProfile {
  implicit lazy val executionContext: ExecutionContext = ExecutionContext.global
  implicit lazy val actorSystem: ActorSystem = ActorSystem("star-system")
  implicit lazy val materializer: ActorMaterializer = ActorMaterializer()

  sys.addShutdownHook {
    actorSystem.terminate()
  }
}
