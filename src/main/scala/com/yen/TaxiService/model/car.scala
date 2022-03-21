package com.yen.TaxiService.model

// TODO : optimize below
case class Location(var x: Int, var y: Int)
case class Car(id:Int, var source:Location, var destination:Location, var free:Boolean)

object test extends App {
  var car1 = Car(1, Location(0,0), Location(0,0),false)
//  car1.destination.locationX = 1
//  car1.destination.locationY = 2
  car1.destination = Location(1,2)
  println(car1)
}