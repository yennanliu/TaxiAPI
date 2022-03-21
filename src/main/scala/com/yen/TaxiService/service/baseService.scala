package com.yen.TaxiService.service

import com.yen.TaxiService.model.{Car, Location}

import scala.collection.mutable.ArrayBuffer

trait baseService {
  // attr

  // method
  def book(carId:Int, destination:Location):Boolean
  def checkNearest(src:Location):Int
  def listAll():String
  def reset()
  def tick()
}
