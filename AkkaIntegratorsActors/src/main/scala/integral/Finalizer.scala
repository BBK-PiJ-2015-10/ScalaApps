package integral

import akka.actor._

class Finalizer extends Actor {
  
  var result: Int = _
  var accumulator: Double = _
  val startTime: Long = System.currentTimeMillis
  
  def receive = {
    
    case ResultAccumulation(value) =>
      accumulator += value
      result += 1
    
    case Finalize =>
      println("I am done", accumulator / result)
      //println("\n\t Integration result: \t%s\n\tCalculation time: \t%s").format(accumulator / result, (System.currentTimeMillis - startTime) millis)
    
      context.system.terminate()
        
  }
  
}