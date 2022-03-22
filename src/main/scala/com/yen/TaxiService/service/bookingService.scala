package com.yen.TaxiService.service

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import com.yen.TaxiService.model.{Car, Location, bookResponse, eventTime}
import com.yen.TaxiService.common.Common.{InitCars, getDistance}

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
      // TODO : optimize below
      val carID = checkNearest(src)
      println(">>> carID = " + carID)
      carID match {
        case _ if carID > 0 => {
          val tmpID = carID-1
          val tmpCar = cars(tmpID)
          tmpCar.destination = dest
          tmpCar.free = false
          this.cars(tmpID) = tmpCar
          println(s"car ${tmpCar.id} is booked ! : ${tmpCar.toString}")
          bookResponse(carID, this.total_time)
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
    // get distance from all cars with src
    var res:ListBuffer[(Int,Int)] = cars.map{
          car => {
            car.free match {
              case _ if car.free == true => {
                val dist = getDistance(car.source, expectedSrc)
                (car.id, dist.toInt)
              }
              case _ => (0,0)
            }
          }
    }.filter(x => x._1 > 0).sortBy(_._1)

    println(">>> res = " + res)

    if (res.length > 0){
      res(0)._1
    }else{
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
        if (car.travelTime >= getDistance(car.source, car.destination)){
          car.free = true
          car.travelTime = 0
          car.source = car.destination
          car.destination = Location(0,0)
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
