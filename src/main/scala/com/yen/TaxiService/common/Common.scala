package com.yen.TaxiService.common

import com.yen.TaxiService.model.Location

object Common {

  def getDistance(src:Location, dest:Location):Float = {
    val diffX = (dest.x - src.y).abs
    val diffY = (dest.x - src.y).abs
    diffX * diffX + diffY * diffY
  }
}
