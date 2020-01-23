package com.andersenlab.spaceinv.modules

import com.andersenlab.spaceinv.api.service.PlanetServiceImpl
import com.andersenlab.spaceinv.dao.PlanetDaoImpl

import scala.concurrent.ExecutionContext.Implicits.global
import DbSetup.db
import com.andersenlab.spaceinv.api.controller.PlanetController

object PlanetModul {
  lazy val planetDao = new PlanetDaoImpl()
  lazy val planetService = new PlanetServiceImpl(db, planetDao)
  lazy val planetController = new PlanetController(planetService)

}
