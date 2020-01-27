package com.andersenlab.spaceinv.model

import com.andersenlab.spaceinv.dao.ExtPostgresProfile.api._

case class Mass(kilos: Double) extends AnyVal

case class Coordinates(x: Double, y: Double, z: Double)

trait CoordinateColumns {
  this: Table[_] =>
  def xAxis = column[Double]("X_AXIS")

  def yAxis = column[Double]("Y_AXIS")

  def zAxis = column[Double]("Z_AXIS")

  def coordinates = (xAxis, yAxis, zAxis).mapTo[Coordinates]
}

case class Radius(kilometers: Double) extends AnyVal

case class PhysicalCharacteristics(mass: Mass,
                                   radius: Radius,
                                   coordinates: Coordinates)

trait PhysicalCharacteristicsColumns extends CoordinateColumns {
  this: Table[_] =>
  def mass = column[Mass]("MASS")

  def radius = column[Radius]("RADIUS")

  def characteristics = (mass, radius, coordinates).mapTo[PhysicalCharacteristics]
}