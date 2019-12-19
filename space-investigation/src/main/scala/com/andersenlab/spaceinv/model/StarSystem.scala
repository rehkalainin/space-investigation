package com.andersenlab.spaceinv.model

import java.util.UUID

import slick.jdbc.PostgresProfile.api._

case class StarSystem(id: UUID,
                      name: String)

class StarSystemTable(tag:Tag) extends Table[StarSystem](tag, "StarSystemTable"){
  def id= column[UUID]("SS_ID", O.PrimaryKey, O.AutoInc)
  def name= column[String]("SS_NAME")

  def * = (id,name).mapTo[StarSystem]
}


