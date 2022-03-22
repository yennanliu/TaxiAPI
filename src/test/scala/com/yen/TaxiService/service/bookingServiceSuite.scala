package com.yen.TaxiService.service

import org.scalatest.funsuite.AnyFunSuite
import com.yen.TaxiService.service.bookingService
import com.yen.TaxiService.model.{Car, Location}

import scala.collection.mutable.ListBuffer

class bookingServiceSuite extends AnyFunSuite{

  test("book"){

  }

  test("checkNearest"){
    val book_service = new bookingService()
    val carId1 = book_service.checkNearest(Location(0,0))
    assert(carId1==1)
  }

  test("listAll"){
    val book_service = new bookingService()
    val expected = "Car(1,Location(0,0),Location(0,0),true,0)Car(2,Location(0,0),Location(0,0),true,0)Car(3,Location(0,0),Location(0,0),true,0)"
    assert(book_service.listAll().replace("\n","") == expected)
  }

  test("reset"){
    val book_service = new bookingService()

    //book_service.cars = ListBuffer(Car(1,Location(0,0),Location(0,0),true,0), Car(2,Location(0,0),Location(0,0),true,0), Car(3,Location(0,0),Location(0,0),true,0))
    assert(book_service.cars == ListBuffer(Car(1,Location(0,0),Location(0,0),true,0), Car(2,Location(0,0),Location(0,0),true,0), Car(3,Location(0,0),Location(0,0),true,0)))

    book_service.cars = ListBuffer(Car(1,Location(1,1),Location(0,0),true,0), Car(2,Location(2,2),Location(0,0),true,0), Car(3,Location(3,3),Location(0,0),false,0))
    assert(book_service.cars == ListBuffer(Car(1,Location(1,1),Location(0,0),true,0), Car(2,Location(2,2),Location(0,0),true,0), Car(3,Location(3,3),Location(0,0),false,0)))

    book_service.reset()
    assert(book_service.cars == ListBuffer(Car(1,Location(0,0),Location(0,0),true,0), Car(2,Location(0,0),Location(0,0),true,0), Car(3,Location(0,0),Location(0,0),true,0)))
  }

  test("updateStatus"){

  }

  test("tick"){
    val book_service = new bookingService()
    assert (book_service.total_time==0)
    book_service.tick()
    assert (book_service.total_time==1)
    book_service.tick()
    assert (book_service.total_time==2)
  }

}
