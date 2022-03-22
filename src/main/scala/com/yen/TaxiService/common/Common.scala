package com.yen.TaxiService.common

import com.yen.TaxiService.model.Location

object Common {

  def getDistance(src:Location, dest:Location):Float = {
    println(">>> src = " + src + " dest = " + dest)
    val diffX = (dest.x - src.x)
    val diffY = (dest.y - src.y)
    println("diffX = " + diffX + " diffY = " + diffY)
    diffX * diffX + diffY * diffY
  }
}
