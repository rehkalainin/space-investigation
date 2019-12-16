package com.andersenlab.spaceinv.model

case class Mass(kilos: Double)

case class Coordinates(x: Double, y: Double, z: Double)

case class Radius(kilometers: Double)

case class PhysicalCharacteristics(mass: Mass,
                                   radius: Radius,
                                   coordinates: Coordinates)