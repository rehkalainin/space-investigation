package com.andersenlab.spaceinv.model

case class Mass(kilos: Double) extends AnyVal

case class Coordinates(x: Double, y: Double, z: Double)

case class Radius(kilometers: Double) extends AnyVal

case class PhysicalCharacteristics(mass: Mass,
                                   radius: Radius,
                                   coordinates: Coordinates)