package com.andersenlab.spaceinv.api.service

import java.util.UUID

import org.scalamock.scalatest.MockFactory
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}
import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api.Database
import com.andersenlab.spaceinv.dao.StarDao
import com.andersenlab.spaceinv.model.{Coordinates, Mass, PhysicalCharacteristics, Radius, Star, StarType}
import slick.dbio.DBIOAction

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class StarServiceTest extends WordSpec
  with Matchers
  with ScalaFutures
  with MockFactory
  {

  val dbMock = mock[Database]
  val starDaoMock = mock[StarDao]
  val starService = new StarServiceImpl(dbMock, starDaoMock)

  val starTest = Star(id = UUID.randomUUID(), "Mars", starSystemId = UUID.randomUUID(),
    PhysicalCharacteristics(Mass(1000), Radius(1500), Coordinates(1, 2, 3)), StarType.LikeSun)

  "StarServiceImpl " should {
    "successfully get Star by Id " in  {
      (starDaoMock.findStarById _).expects(starTest.id).returning(DBIOAction.successful(Some(starTest)))
//      (dbMock.run _).expects(Future.successful()).returning(Future.successful(starTest))

    }


  }

  //  "StarServiceImpl" should {
  //    "successfully get Star by Id " in new Scope {
  //      starDao.findStarById(any[UUID]) shouldReturn DBIOAction.successful(None)
  //      Mockito.when(db.run(*)).thenReturn(Future.never)
  //      // db.run(*) shouldReturn Future.successful(())
  //      starService.findStarById(UUID.randomUUID()).futureValue shouldEqual (())
  //    }
  //    "fail during getting Star by Id " in new Scope {
  //      starDao.findStarById(*) shouldReturn DBIOAction.successful(None)
  //      db.run(*) shouldReturn Future.failed(new RuntimeException(" Some Error"))
  //      the[RuntimeException] thrownBy starService.findStarById(UUID.randomUUID()) should have message "Some Error"
  //    }

}
