package com.yen.TaxiService.model

case class location(locationX: Int, locationY: Int)
case class car(id:Int, source:location, destination:location, free:Boolean)
