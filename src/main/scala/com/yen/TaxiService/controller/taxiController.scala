package com.yen.TaxiService.controller

import com.twitter.finatra.http.Controller
import com.twitter.finagle.http.Request

import com.yen.TaxiService.model.bookRequest
import com.yen.TaxiService.service.bookingService

object taxiController {
  val book_service = new bookingService()

  // book
  class book extends Controller {
    post("/api/book"){
      request:bookRequest =>
        //val url = requests.url
        //url_service.hashUrl(url)
        val source = request.source
        val destination = request.destination
        val toBookCarID = book_service.checkNearest(source)
        book_service.book(toBookCarID, source, destination)
    }
  }

  // listAll
  class listAllCar extends Controller {
    get("/api/all"){
      require:Request =>
        book_service.listAll()
    }
  }
}
