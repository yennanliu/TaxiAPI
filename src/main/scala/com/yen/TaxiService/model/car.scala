package com.yen.TaxiService.model

// model for location, car
case class Location(var x: Int, var y: Int)
case class Car(id:Int, var source:Location, var destination:Location, var free:Boolean, var travelTime: Int)
