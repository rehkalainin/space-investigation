package com.andersenlab.spaceinv.model

import java.util.UUID

import slick.lifted.Tag
import slick.model.Table

case class StarSystem(id: UUID,
                      name: String)

class StarSystemTable(tag:Tag) extends Table [(UUID,String)](tag,"StarSystem"){

}

