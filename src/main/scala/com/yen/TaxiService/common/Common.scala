package com.yen.TaxiService.common

import scala.collection.mutable.ListBuffer

import com.yen.TaxiService.model.{Car, Location}

/**
 *  Common utils func
 */

object Common {

  // get Manhattan distance between src and dest point
  def getDistance(src:Location, dest:Location):Float = {

    val diffX = (dest.x - src.x).abs
    val diffY = (dest.y - src.y).abs

    diffX + diffY
  }

  // init cars and their status
  def InitCars():ListBuffer[Car] = {
    // init cars
    var car1 = Car(1, Location(0,0), Location(0,0),true, 0)
    var car2 = Car(2, Location(0,0), Location(0,0),true, 0)
    var car3 = Car(3, Location(0,0), Location(0,0),true, 0)

    ListBuffer(car1, car2, car3)
  }
}
