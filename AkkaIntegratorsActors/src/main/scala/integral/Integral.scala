package integral

import akka.actor._

object Integral extends App {
  
  runIntegral(workers =4, samples = 1000, iterations = 1000)
  
  def runIntegral(workers: Int, samples: Int, iterations: Int) {
    
    val system = ActorSystem("IntegralSystem")
    
    val finalizer = system.actorOf(Props[Finalizer], name="finalizer")
    
    val initializer = system.actorOf(Props(new Initializer(workers,samples,iterations,finalizer)), name="initializer")
   
    initializer ! Execute
    
  }
  
  
}