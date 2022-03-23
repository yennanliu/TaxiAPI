package com.yen.TaxiService

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

import com.yen.TaxiService.controller.taxiController

/**
 *  main application
 */

// entry point
object App extends serviceApp

class serviceApp extends HttpServer{

  override val defaultHttpsPort: String = ":8080"

  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[taxiController.book]
    router.add[taxiController.listAllCar]
    router.add[taxiController.resetStatus]
    router.add[taxiController.tickClock]
  }

}
