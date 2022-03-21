package com.yen.TaxiService.service

import com.yen.TaxiService.model.Location

trait baseService {
  // attr

  // method
  def book(carId:Int, source:Location, destination:Location):Boolean
  def checkNearest(src:Location):Int
  def reset()
  def tick()
}
