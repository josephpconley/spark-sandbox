package intro

import common.SparkApp

object Tutorial extends SparkApp {
  val evens = sc.parallelize(0 to 100000 by 2, 1)

  println(evens.id)
  println(evens.name)

  evens.map(_ + 1).take(100).foreach(println)
}
