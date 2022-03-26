package com.yen.TaxiService.common

object Parse {

  // read information from file
  def parseFile(fileName:String):String ={
    val lines = scala.io.Source.fromFile(fileName).toList
    var output = ""
    lines.map{
      line =>
        val _info = line.toString//.split(",")
        output += (_info)
    }.flatMap(_.toString)
    output
  }

}
