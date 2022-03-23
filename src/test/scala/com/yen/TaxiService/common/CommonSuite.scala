package com.yen.TaxiService.common

import org.scalatest.funsuite.AnyFunSuite
import com.yen.TaxiService.model.{Car, Location}

import scala.collection.mutable.ListBuffer

class CommonSuite extends AnyFunSuite{

  test("getDistance"){
    val dist1 = Common.getDistance(Location(0,0), Location(3,4))
    assert(dist1 == 7)

    val dist2 = Common.getDistance(Location(3,4), Location(0,0))
    assert(dist2 == 7)

    val dist3 = Common.getDistance(Location(0,0), Location(0,0))
    assert(dist3 == 0)
  }

  test("initCars"){
    var cars = Common.InitCars()
    assert(cars.length == 3)
    assert(cars==ListBuffer(Car(1,Location(0,0),Location(0,0),true,0), Car(2,Location(0,0),Location(0,0),true,0), Car(3,Location(0,0),Location(0,0),true,0))
    )
  }

}
