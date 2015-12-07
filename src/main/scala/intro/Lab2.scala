package intro

import common.SparkApp

object Lab2 extends App {

  val process = Runtime.getRuntime.exec(Array[String]("/tmp/test.sh", "/tmp/test.zip"))
  process.waitFor

  println("done")
}
