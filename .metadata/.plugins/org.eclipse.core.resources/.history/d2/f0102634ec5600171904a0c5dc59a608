package integral


import akka.actor._
import akka.routing._
import scala.math._

class Initializer(workers: Int, samples: Int, iterations: Int, finalizer: ActorRef) extends Actor {
  
  var results: Int = _
  
  val workerRouter = context.actorOf(Props[Integrator].withRouter(RoundRobinPool(workers)), name="workerRouter")
  
  def receive = {
    
    case Execute =>
      for (i <- 0 until samples) workerRouter ! Integrate(iterations,d => pow(d,2))
    
    case Result(value) =>
      finalizer ! ResultAccumulation(value)
      results +=1
      if (results==sample){
        finalizer ! Finalize
        //Stops this actor and all its supervised children
        context stop self
      }
      
      
  }
  
}