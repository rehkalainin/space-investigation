package com.andersenlab.spaceinv.modules

import com.andersenlab.spaceinv.api.service.StarSystemServiceImpl
import DbSetup.db
import com.andersenlab.spaceinv.dao.StarSystemDaoImpl
import CoreExecutionProfile.executionContext
import com.andersenlab.spaceinv.api.controller.StarSystemController

object StarSystemModule {
  lazy val starSystemDao = new StarSystemDaoImpl
  lazy val starSystemService = new StarSystemServiceImpl(db, starSystemDao)
  lazy val starSystemController = new StarSystemController(starSystemService)
}
