package com.yen.TaxiService.service

import scala.collection.mutable.ListBuffer
import com.yen.TaxiService.model.{Car, Location, eventTime, bookResponse}
import com.yen.TaxiService.common.Common.{getDistance, InitCars}

/**
 *  Taxi booking service
 */

class bookingService extends baseService {

  // init time
  var total_time = 0
  // init cars
  var cars = InitCars()

  override def book(src: Location, dest: Location):bookResponse = {
    try{
      // TODO : fix below
      val carID = checkNearest(src)
      carID match {
        case _ if carID > 0 => {
          val tmpID = carID-1
          val tmpCar = cars(tmpID)
          tmpCar.destination = dest
          tmpCar.free = false
          this.cars(tmpID) = tmpCar
          println(s"car ${tmpCar.id} is booked ! : ${tmpCar.toString}")
          bookResponse(tmpID, this.total_time)
        }
        case _ => {
          println("no available car")
          bookResponse(0, this.total_time)
        }
      }
    }catch{
      case e:RuntimeException => {
        e.printStackTrace()
        bookResponse(0, this.total_time)
      }
    }
  }

  override def checkNearest(expectedSrc:Location):Int = {
    // TODO : use functional way
    // get distance from all cars with src
    //    val res = cars.map{
    //      car => {
    //        val (id, val) = Common.getDistance(src, car.source)
    //      }
    //    }

    //println(">>> expectedSrc = " + expectedSrc.toString)
    var res = scala.collection.mutable.Map.empty[Int,Float]
    // TODO : fix
    var resId = -1
    var initDist = Float.MaxValue
    for (car <- cars){
      if (car.free == true){
        val dist = getDistance(car.source, expectedSrc)
        res(car.id) = dist
//        val tmp = (car.id, dist)
      }
    }
    println(">>> res = " + res.toString())
//    println(">>> res.toSeq.sortBy(_._1) = " + res.toSeq.sortBy(_._1).toString())

    // if there is car available
    if (res.toSeq.length > 0){
      res.toSeq.sortBy(_._1).toList(0)._1
    }else{
      // if no car available
      0
    }
  }

  override def listAll():String = {
    var res = ""
    for (car <- cars){
      res += car.toString + "\n"
    }
    res
  }

  override def reset(): Unit = {
    try{
      this.cars = InitCars()
      println("reset OK")
    }catch {
      case e:RuntimeException => {
        println("reset failed")
        e.printStackTrace()
      }
    }
  }

  override def updateStatus(): Unit = {
    for (car <- cars){
      if (car.free == false){
        car.travelTime = this.total_time
        println(">>> getDistance(car.source, car.destination) = " + getDistance(car.source, car.destination))
        if (car.travelTime > getDistance(car.source, car.destination)){
          car.free = true
          car.travelTime = 0
        }
      }
    }
  }

  override def tick(): Int = {
    this.total_time += 1
    updateStatus()
    this.total_time
  }

}
