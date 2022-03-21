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
  var car1 = Car(1, Location(0,0), Location(0,0),false)
  var car2 = Car(2, Location(0,0), Location(0,0),false)
  var car3 = Car(3, Location(0,0), Location(0,0),false)

  val cars = ListBuffer(car1, car2, car3)

  override def book(carId: Int, src: Location, dest: Location):Boolean = {
    try{
      // TODO : fix below
      // checkNearest
      //car1.destination = destination
      cars(carId-1).destination = dest
      true
    }catch{
      case e:RuntimeException => {
        e.printStackTrace()
        false
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
    var resId = 10
    var initDist = Float.MaxValue
    for (car <- cars){
      val dist = Common.getDistance(car.source, expectedSrc)
      if (dist < initDist){
        resId = car.id
      }
    }
    resId
  }

  override def reset(): Unit = ???

  override def tick(): Unit = ???
}
