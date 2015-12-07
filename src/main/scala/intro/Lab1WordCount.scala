package intro

import common.SparkApp

object Lab1WordCount extends SparkApp {

  val wordCounts = sc.textFile("notes.txt", 8)
    .flatMap(_.trim.split("""[\s\W]+"""))
    .filter(_.size > 3)
    .map(word => word.toLowerCase -> 1)
    .reduceByKey(_ + _)
    .cache()

  val totalCount = wordCounts.map(_._2).sum()
  val uniqueCount = wordCounts.filter(_._2 == 1).count()
  val mean = uniqueCount / totalCount


}
