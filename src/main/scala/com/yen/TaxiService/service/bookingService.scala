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
  var car2 = Car(2, Location(10,0), Location(0,0),true)
  var car3 = Car(3, Location(20,0), Location(0,0),true)

  var cars = ListBuffer(car1, car2, car3)

  override def book(src: Location, dest: Location):Int = {
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
          tmpID
        }
        case _ => {
          println("no valid car")
          0
        }
      }
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

    println(">>> expectedSrc = " + expectedSrc.toString)
    var res = scala.collection.mutable.Map.empty[Int,Float]
    // TODO : fix
    var resId = -1
    var initDist = Float.MaxValue
    for (car <- cars){
      if (car.free == true){
        val dist = Common.getDistance(car.source, expectedSrc)
        res(car.id) = dist
//        val tmp = (car.id, dist)
      }
    }
    println(">>> res = " + res.toString())
//    println(">>> res.toSeq.sortBy(_._1) = " + res.toSeq.sortBy(_._1).toString())
//    println(">>> res.toSeq.sortBy(_._1).toList(1) = " + res.toSeq.sortBy(_._1).toList(0))

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
