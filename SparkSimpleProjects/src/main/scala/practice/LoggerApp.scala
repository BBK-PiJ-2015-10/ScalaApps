package practice

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;

object LoggerApp extends App {
  
  println("Welcome to logger App Mimasone")
  
  val configuration = new SparkConf().setAppName("LoggerApp").setMaster("local[*]")
  
  val sparkContext = new SparkContext(configuration)
  
  val lines = sparkContext.textFile("logger/log.txt")
  
  val errors = lines.filter(_.startsWith("ERROR"))
  
  val messages = errors.map(_.split("\t")).map(r=>r(1))
  
  messages.saveAsTextFile("logger/output.txt")
      
  //messages.cache()
  
  //messages.foreach(n=>println(n))
  
  sparkContext.stop()
  
  println("Context has been finalized")
  
}