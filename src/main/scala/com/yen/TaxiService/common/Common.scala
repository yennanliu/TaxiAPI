package com.yen.TaxiService.common

import com.yen.TaxiService.model.{Car, Location}

import scala.collection.mutable.ListBuffer

/**
 *  Common utils func
 */

object Common {

  def getDistance(src:Location, dest:Location):Float = {

    val diffX = (dest.x - src.x)
    val diffY = (dest.y - src.y)

    diffX * diffX + diffY * diffY
  }

  def InitCars():ListBuffer[Car] = {
    // init cars
    var car1 = Car(1, Location(0,0), Location(0,0),true, 0)
    var car2 = Car(2, Location(0,0), Location(0,0),true, 0)
    var car3 = Car(3, Location(0,0), Location(0,0),true, 0)

    ListBuffer(car1, car2, car3)
  }
}
