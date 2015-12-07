package common

import org.apache.spark.{SparkConf, SparkContext}

trait SparkApp extends App {

  val sc = new SparkContext(new SparkConf().setMaster("local[4]").setAppName("App"))
}
