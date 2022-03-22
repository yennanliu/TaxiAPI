package com.yen.TaxiService.common

import com.yen.TaxiService.model.Location

object Common {

  def getDistance(src:Location, dest:Location):Float = {

    val diffX = (dest.x - src.x)
    val diffY = (dest.y - src.y)

    diffX * diffX + diffY * diffY
  }
}
