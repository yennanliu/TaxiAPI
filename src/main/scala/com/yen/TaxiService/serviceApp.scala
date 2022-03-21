package com.yen.TaxiService

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

import com.yen.TaxiService.controller.baseController

// entry point
object App extends serviceApp

class serviceApp extends HttpServer{
  override protected def configureHttp(router: HttpRouter): Unit = {
//    router.add[Controller.hello]
//    router.add[Controller.getAllHero]
  }
}
