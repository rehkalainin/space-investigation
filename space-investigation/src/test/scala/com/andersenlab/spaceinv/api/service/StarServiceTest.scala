package com.andersenlab.spaceinv.api.service

import java.util.UUID

import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api.Database
import com.andersenlab.spaceinv.dao.StarDao
import org.mockito.{ArgumentMatchersSugar, IdiomaticMockito}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import slick.dbio.DBIOAction

import scala.concurrent.Future

class StarServiceTest extends WordSpec
  with Matchers
  with IdiomaticMockito
  with ScalaFutures
  with ArgumentMatchersSugar {

  "StarServiceImpl" should {
    "successfully get Star by Id " in new Scope {
      starDao.findStarById(*) shouldReturn DBIOAction.successful(None)
      db.run(*) shouldReturn Future.successful(())
      starService.findStarById(UUID.randomUUID()).futureValue shouldEqual (())
    }
    "fail during getting Star by Id " in new Scope {
      starDao.findStarById(*) shouldReturn DBIOAction.successful(None)
      db.run(*) shouldReturn Future.failed(new RuntimeException(" Some Error"))
      the[RuntimeException] thrownBy starService.findStarById(UUID.randomUUID()) should have message "Some Error"
    }
  }

  trait Scope {

    import scala.concurrent.ExecutionContext.Implicits.global

    val db = mock[Database]
    val starDao = mock[StarDao]
    val starService = new StarServiceImpl(db, starDao)
  }

}
