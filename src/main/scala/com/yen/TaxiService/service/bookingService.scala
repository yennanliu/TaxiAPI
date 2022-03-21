package com.yen.TaxiService.service

import scala.collection.mutable.ListBuffer

import com.yen.TaxiService.model.{Car, Location}
import com.yen.TaxiService.common.Common

/**
 *
 * You are tasked to implement a simple taxi booking system in a 2D grid world with the following criteria:
 *
 * - The 2D grid world consists of `x` and `y` axis that each fit in a 32 bit integer, i.e. `-2,147,483,648` to `2,147,483,647`.
 * - There are **3** cars in the system, All three cars should have id `1`, `2` and `3` respectively and initial start location is at origin `(0, 0)`. Note that you can store the car states in memory and there is no need for persistent storage for this exercise.
 * - A car travels through the grid system will require **1 time unit** to move along the `x` or `y` axis by **1 unit** (i.e. Manhattan distance). For example
 *   - Car at `(0, 0)` will reach `(0, 2)` in 2 time units.
 *   - Car at `(1, 1)` will reach `(4, 4)` in 6 time units.
 *   - More than 1 car can be at the same point at any time.
 */

class bookingService extends baseService {

  // TODO : fix this to conf
  // init cars
  var car1 = Car(1, Location(0,0), Location(0,0),true)
  var car2 = Car(2, Location(0,0), Location(0,0),true)
  var car3 = Car(3, Location(0,0), Location(0,0),true)

  var cars = ListBuffer(car1, car2, car3)

  override def book(carId: Int, src: Location, dest: Location):Int = {
    try{
      // TODO : fix below
      val carID = checkNearest(src)
      val car = cars(carID-1)
      car.destination = dest
      car.free = false
      this.cars(carID) = car
      println(s"car ${car.id} is booked ! : ${car.toString}")
      car.id
    }catch{
      case e:RuntimeException => {
        e.printStackTrace()
        0
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

    //var res = scala.collection.mutable.Map.empty[Int,Float]
    // TODO : fix
    var resId = -1
    var initDist = Float.MaxValue
    for (car <- cars){
      val dist = Common.getDistance(car.source, expectedSrc)
      println("car.id = " + car.id + " dist = " + dist)
      if (dist < initDist && car.free == true){
        resId = car.id
        initDist = dist
      }
    }
    resId
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
      this.car1 = Car(1, Location(0,0), Location(0,0),false)
      this.car2 = Car(2, Location(0,0), Location(0,0),false)
      this.car3 = Car(3, Location(0,0), Location(0,0),false)
      this.cars = ListBuffer(this.car1, this.car2, this.car3)
      println("reset OK")
    }catch {
      case e:RuntimeException => {
        println("reset failed")
        e.printStackTrace()
      }
    }
  }

  override def tick(): Unit = ???
}
