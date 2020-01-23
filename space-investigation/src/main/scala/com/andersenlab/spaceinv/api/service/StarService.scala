package com.andersenlab.spaceinv.api.service

import java.util.UUID

import com.andersenlab.spaceinv.api.modelView.StarView
import com.andersenlab.spaceinv.model.Star
import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api.Database
import com.andersenlab.spaceinv.dao.StarDao

import scala.concurrent.{ExecutionContext, Future}

trait StarService {
  def findStarById(starId: UUID): Future[Option[StarView]]

  def listAll(): Future[List[Star]]

  def save(star: Star): Future[Unit]

  def update(star: Star): Future[Unit]

}

class StarServiceImpl(db: Database,
                      starDao: StarDao)(implicit ec: ExecutionContext) extends StarService {

  override def findStarById(starId: UUID): Future[Option[StarView]] = {
    db.run {
      starDao.findStarById(starId).map(_.map(StarView.fromStar))
    }
  }

  override def listAll(): Future[List[Star]] = {
    db.run {
      starDao.listAll()
    }
  }

  override def save(star: Star): Future[Unit] = {
    db.run {
      starDao.saveStar(star).map(_ => ())
    }
  }

  override def update(star: Star): Future[Unit] = {
    db.run {
      starDao.updateStar(star).map(_ => ())
    }
  }
}

