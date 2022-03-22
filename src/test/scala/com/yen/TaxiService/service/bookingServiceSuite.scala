package com.yen.TaxiService.service

import org.scalatest.funsuite.AnyFunSuite
import com.yen.TaxiService.service.bookingService
import com.yen.TaxiService.model.{Car, Location, bookResponse}

import scala.collection.mutable.ListBuffer

class bookingServiceSuite extends AnyFunSuite{

  test("book"){
    val book_service = new bookingService()

    val res1 = book_service.book(Location(0,0), Location(5,5))
    //println(book_service.cars)
    assert(res1 == bookResponse(1,0))
    assert(book_service.cars(0) ==  Car(1,Location(0,0),Location(5,5),false,0))

    val res2 = book_service.book(Location(0,0), Location(5,5))
    assert(res2 == bookResponse(2,0))
    assert(book_service.cars(1) ==  Car(2,Location(0,0),Location(5,5),false,0))

    val res3 = book_service.book(Location(0,0), Location(5,5))
    assert(res3 == bookResponse(3,0))
    assert(book_service.cars(2) ==  Car(3,Location(0,0),Location(5,5),false,0))

    val res4 = book_service.book(Location(0,0), Location(5,5))
    assert(res4 == bookResponse(0,0))
  }

  test("checkNearest"){
    val book_service = new bookingService()
    val carId1 = book_service.checkNearest(Location(1,1))
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
