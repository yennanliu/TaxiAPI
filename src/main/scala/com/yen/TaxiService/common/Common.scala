package com.yen.TaxiService.common

import com.yen.TaxiService.model.Location

object Common {

  def getDistance(src:Location, dest:Location):Float = {
    val diffX = (dest.locationX - src.locationX).abs
    val diffY = (dest.locationY - src.locationY).abs
    diffX * diffX + diffY * diffY
  }
}
