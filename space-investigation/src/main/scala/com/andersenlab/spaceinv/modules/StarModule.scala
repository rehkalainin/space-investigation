package com.andersenlab.spaceinv.modules

import com.andersenlab.spaceinv.api.service.StarServiceImpl
import com.andersenlab.spaceinv.dao.StarDaoImpl
import DbSetup.db
import com.andersenlab.spaceinv.api.controller.StarController

import scala.concurrent.ExecutionContext.Implicits.global

object StarModule {
  lazy val starDao = new StarDaoImpl()
  lazy val starService = new StarServiceImpl(db, starDao)
  lazy val starController = new StarController(starService)

}
