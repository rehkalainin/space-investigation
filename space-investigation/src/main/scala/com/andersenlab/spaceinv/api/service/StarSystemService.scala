package com.andersenlab.spaceinv.api.service

import java.util.UUID
import com.andersenlab.spaceinv.api.model.StarSystemView
import scala.concurrent.{ExecutionContext, Future}
import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api.Database
import com.andersenlab.spaceinv.dao.StarSystemDao
import com.andersenlab.spaceinv.model.StarSystem

trait StarSystemService {
  def findStarSystem(starSystemId: UUID): Future[Option[StarSystemView]]

  def listAll(): Future[List[StarSystem]]
}

class StarSystemServiceImpl(db: Database,
                            starSystemDao: StarSystemDao)(implicit ec: ExecutionContext) extends StarSystemService {
  override def findStarSystem(starSystemId: UUID): Future[Option[StarSystemView]] = {
    db.run {
      starSystemDao.findStarSystem(starSystemId)
    }
  }

  override def listAll(): Future[List[StarSystem]] = {
    // todo: implement
    ???
  }
}
