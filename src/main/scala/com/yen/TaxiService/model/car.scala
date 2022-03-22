package com.yen.TaxiService.model

// TODO : optimize below
case class Location(var x: Int, var y: Int)
case class Car(id:Int, var source:Location, var destination:Location, var free:Boolean)
