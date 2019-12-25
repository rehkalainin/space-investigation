package com.andersenlab.spaceinv.model

import java.util.UUID

import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api._

case class StarSystem(id: UUID,
                      name: String)

class StarSystemTable(tag:Tag) extends Table[StarSystem](tag, "StarSystemTable"){
  def id= column[UUID]("SS_ID", O.PrimaryKey)
  def name= column[String]("SS_NAME")

  def * = (id,name).mapTo[StarSystem]
}

object StarSystemTable {
  val starSystem = TableQuery[StarSystemTable]
}
