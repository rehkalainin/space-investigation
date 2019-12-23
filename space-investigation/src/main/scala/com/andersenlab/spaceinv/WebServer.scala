package com.andersenlab.spaceinv
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer

import scala.concurrent.Future
import scala.io.StdIn

object WebServer extends App{

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

//  val route: Route =
//    path ("hello"){
//      get {
//        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1> Hello to akka-http !!! </h1>"))
//      }
//    }
//  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)
//  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
//  StdIn.readLine() // let it run until user presses return
//  bindingFuture
//    .flatMap(_.unbind()) // trigger unbinding from the port
//    .onComplete(_ => system.terminate()) // and shutdown when done

  val routes: Route =
    path("hello") {
      get {
        complete("Running ... ")
      }
    }
  val bindingFuture: Future[Http.ServerBinding] = Http().bindAndHandle(routes,"localhost", 8000)
    .recoverWith {
    case _ => sys.exit(1)
  }
  sys.addShutdownHook(
    bindingFuture.map(_.unbind())
)
}
