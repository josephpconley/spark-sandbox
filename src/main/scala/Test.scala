import common.SparkApp

object Test extends SparkApp {

  val start = System.currentTimeMillis()

  val wordsRDD = sc.textFile("notes.txt")
    .flatMap(_.trim.split("""[\s\W]+"""))
    .filter(_.size > 3)
    .map(word => word.toLowerCase -> 1)
    .reduceByKey(_ + _)
    .sortBy(_._2, ascending = false)
    .take(10)
    .foreach {
      println
    }

  val duration = System.currentTimeMillis() - start
  println(s"Job took $duration ms")
}
